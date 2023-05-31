package top.kjwang.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author kjwang
 * @date 2023/3/30 16:17
 * @description Address
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Indexed
    private String city;

    @Indexed
    private String country;
}
