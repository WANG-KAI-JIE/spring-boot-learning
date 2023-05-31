package top.kjwang.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author kjwang
 * @date 2023/3/30 16:18
 * @description Family
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Family {
    @Indexed
    private String type;

    @Indexed
    private String username;
}