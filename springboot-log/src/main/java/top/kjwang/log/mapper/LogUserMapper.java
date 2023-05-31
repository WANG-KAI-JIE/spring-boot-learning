package top.kjwang.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.kjwang.log.entity.LogUser;

/**
 * @author kjwang
 * @date 2023/4/3 16:23
 * @description LogUserMapper
 */
@Repository
@Mapper
public interface LogUserMapper extends BaseMapper<LogUser> {
}
