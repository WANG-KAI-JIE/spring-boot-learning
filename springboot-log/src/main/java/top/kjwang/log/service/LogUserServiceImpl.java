package top.kjwang.log.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.kjwang.log.entity.LogUser;
import top.kjwang.log.mapper.LogUserMapper;


/**
 * @author kjwang
 * @date 2023/4/3 16:25
 * @description LogUserServiceImpl
 */

@Service
public class LogUserServiceImpl extends ServiceImpl<LogUserMapper, LogUser> implements ILogUserService {
}

