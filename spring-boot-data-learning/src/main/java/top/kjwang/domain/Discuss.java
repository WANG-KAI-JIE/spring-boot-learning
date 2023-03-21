package top.kjwang.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kjwang
 * @Date 2023/3/20 14:09
 * @description Discuss：针对 t_comment 的实体类
 */
@Entity(name = "t_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Discuss {
    /**
     * 指定主键自增策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;

    private String author;
    private String content;

    @Column(name = "a_id")
    private Integer AId;



}
