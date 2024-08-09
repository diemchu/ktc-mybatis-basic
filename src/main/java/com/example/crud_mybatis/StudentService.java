package com.example.crud_mybatis;

import com.example.crud_mybatis.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


// 사용자의 수집한 정보를 조작해서 데이터베이스에 저장
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentDao dao;
//    public StudentService(StudentDao dao) {
//        this.dao = dao;
//    }

    public void create(
            String name,
            Integer age,
            String phone,
            String email
    ) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAge(age);
        dao.createStudent(student);
    }

    public List<Student> readAll() {
        return dao.readStudentAll();
    }

    public Student readOne(Long id) {
        return dao.selectOneStudent(id);
    }

    public void update(Long id,
                       String name,
                       Integer age,
                       String phone,
                       String email) {
        //원래 데이터를 가저온다
        Student target = dao.selectOneStudent(id);
        target.setName(name);
        target.setAge(age);
        target.setEmail(email);
        target.setPhone(phone);
        dao.updateStudent(target);
    }


}
