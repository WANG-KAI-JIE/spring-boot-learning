package top.kjwang.exception.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

/**
 * @author kjwang
 * @date 2023/3/28 14:54
 * @description Article
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Min(value = 4,message = "文章 id 不能小于4")
    private Integer id;

    @NotEmpty(message = "文章内容不能为空")
    private String title;
//    @Size(min = 2,max = 10,message = "姓名长度必须在 [2,10] 之间")
    @Length(min = 2,max = 10,message = "姓名长度必须在 [2,10] 之间")
    private String author;

    @Email
    private String email;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;
}
