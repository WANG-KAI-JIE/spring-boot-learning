package top.kjwang.log.commons;

import cn.hutool.core.lang.UUID;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.kjwang.log.annotation.MyLog;
import top.kjwang.log.entity.LogOperation;
import top.kjwang.log.entity.LogUser;
import top.kjwang.log.mapper.LogOperationMapper;
import top.kjwang.log.utils.IpUtils;

import java.lang.reflect.Method;


/**
 * @author kjwang
 * @date 2023/4/3 16:03
 * @description SysLogAspect
 */


/** 系统日志：切面处理类 */
@Aspect
@Component
public class SysLogAspect {
    /**我这里是使用log4j2把一些信息打印在控制台上面，可以不写 */
    private static final Logger log = LogManager.getLogger(SysLogAspect.class);

    /**操作数据库 */
//    这里改过
    @Resource
    private LogOperationMapper logOperationMapper;

    /**
     *  定义切点 @Pointcut
     *  在注解的位置切入代码
     *  这里的意思就是注解写在那个方法上，那个方法就是被切入的。
     */
    @Pointcut("@annotation(top.kjwang.log.annotation.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @Before("logPoinCut()")         //AfterReturning
    public void saveOperation(JoinPoint joinPoint) {
        log.info("---------------接口日志记录---------------");
        //用于保存日志
        LogOperation logOperation = new LogOperation();

        // 这里是获得当前请求的request
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String requestURL = request.getRequestURL().toString();
        logOperation.setUrl(requestURL);

        // 客户端ip  这里还可以与之前做一个比较，如果不同的话，就给他推送消息什么的，说异地登录 什么的。
        String ip = IpUtils.getIpAddr(request);
        logOperation.setLoginIp(ip);

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作--方法上的Log的值
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            //保存操作事件
            String operation = myLog.operation();
            logOperation.setOperation(operation);

            //保存日志类型  这里也可以做扩展 根据不同的类型，你可以做不同的操作
            int type = myLog.type();
            logOperation.setType(type);

            log.info("operation="+operation+",type="+type);
        }

        // 操作人账号、姓名（需要提前将用户信息存到session）
        // 因为这里是模拟 所以偷懒用了个 session
        // 实际上用了security 获取的应该是当前授权对象的信息 而不是从session 中获取
        // 也或者说是从 redis 中获取，这只是提供一个思路，请见谅
        LogUser user = (LogUser) request.getSession().getAttribute("user");
        if(user != null) {
            String userId = user.getId();
            String userName = user.getUsername();
            logOperation.setUserId(userId);
            logOperation.setUsername(userName);
            System.out.println(user);
        }
        log.info("url="+requestURL,"ip="+ip);

        //调用service保存Operation实体类到数据库
        //我id使用的是UUID，不需要的可以注释掉
        String id = UUID.randomUUID().toString().replace("-","");
        logOperation.setId(id);
        logOperationMapper.insert(logOperation);
    }
}

