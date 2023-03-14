package top.kjwang.boot.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author kjwang
 * @Date 2023/3/14 14:34
 * @Component 注解：把 Student 类的实例作为 Bean 注入到 Spring 容器中
 */

@Component
public class Student {
    private String name;
    private Integer id;
    @Value("${student.name}")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
