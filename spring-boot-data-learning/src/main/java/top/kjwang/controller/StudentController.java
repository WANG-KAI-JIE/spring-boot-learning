package top.kjwang.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.kjwang.domain.Clazz;
import top.kjwang.domain.Student;
//import top.kjwang.service.ClazzService;
//import top.kjwang.service.StudentService;

/**
 * @author kjwang
 * @Date 2023/3/21 18:31
 */

@RestController
@AllArgsConstructor
public class StudentController {
//    private final StudentService studentService;
//    private final ClazzService clazzService;

//    @GetMapping("{id}")
//    public Student getStudent(@PathVariable int id) {
//        Student student = studentService.findStudent(id);
//        Clazz clazz = clazzService.findClazz(student.getClazzId());
//        student.getClazz().setTeacher(clazz.getTeacher());
//        return student;
//    }

}
