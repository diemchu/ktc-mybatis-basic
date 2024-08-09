package com.example.crud_mybatis;

import com.example.crud_mybatis.mapper.StudentServiceX;
import com.example.crud_mybatis.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class StudentController {
//    private StudentDao dao;
//
//    public StudentController(StudentDao dao) {
//        this.dao = dao;
//    }
//    @RequestMapping("test")
//    public String test() {
////        System.out.println(dao.readStudentAll());
////        System.out.println(dao.selectStudent(1L));
////        Student s = dao.selectStudent(1L);
////        s.setAge(1000);
////        s.setEmail("test@gmail.come");
////        dao.updateStudent(s);
//        dao.deleteStudent(2L);
//        return "test.html";
//    }

    private final  StudentService service;
    private final StudentServiceX serviceX;

//    public StudentController(StudentService service) {
//        this.service = service;
//    }
    // 정보 입력
    @GetMapping("create-view")
    public String create() {
        return "create-view";
    }
    @PostMapping("create")
    public String create(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email, Model model
            ) {
//        service.create(name, age, phone, email);
        serviceX.createStudent(new Student(name,email,age,phone));
//        model.addAttribute("list",service.readAll());
        model.addAttribute("list",serviceX.readAll());
        return "home";
    }

    ///
    @RequestMapping("home")
    public String home(Model model){
//        model.addAttribute("list",service.readAll());
        model.addAttribute("list",serviceX.readAll());
        return "home";
    }

    //read one student
    @RequestMapping("{id}")
    public String info(@PathVariable("id") Long id,
                       Model model
                       ){
//        Student student = service.readOne(id);
        Student student = serviceX.selectStudent(id);
        model.addAttribute("student",student);
        return "info";
    }

    //
    @GetMapping("{id}/update-view")
    public String updateView(
            @PathVariable("id") Long id,
            Model model

    ){
        model.addAttribute("student",service.readOne(id));
        return  "update-view";
    }
    //
    @PostMapping("{id}")
    public  String update(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            Model model
    ){
//        service.update(id,name,age,phone,email);
        serviceX.updateStudent(new Student(id,name,age,phone,email));
        model.addAttribute("list",service.readAll());
        return  "home";
    }

    @RequestMapping("{id}/delete")
    public String delete(
            @PathVariable("id") Long id){
        serviceX.deleteStudent(id);
        return  "redirect:/home";
    }
}
