package top.kjwang.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author kjwang
 * @Date 2023/3/21 13:59
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;

    /**
     * 管理班级的老师：一对一
     */
    private Teacher teacher;

    /**
     * 班级和学生一对多
     */
    private List<Student> students;
}
