//package top.kjwang.boot.domain;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author kjwang
// * @Date 2023/3/14 14:34
// * @Component 注解：把 Student 类的实例作为 Bean 注入到 Spring 容器中
// */
//
//@Component
//@Data
//public class Student {
//    //@Value注解，读取配置文件中的属性值并**逐个注入**到 Bean 对象的对应属性中。不需要setXX()方法
//    @Value("${person.id}")
//    private int id;
//
//    @Value("${person.name}")
//    private String name;
//
//    private List<String> hobby;
//
//    private String[] family;
//
//    private Map map;
//
//    private Pet pet;
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", hobby=" + hobby +
//                ", family=" + Arrays.toString(family) +
//                ", map=" + map +
//                ", pet=" + pet +
//                '}';
//    }
//}