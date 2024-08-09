package com.example.crud_mybatis.mapper;

import com.example.crud_mybatis.StudentDao;
import com.example.crud_mybatis.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceX
{
    private final  StudentDaoX daoX;

    public StudentServiceX(StudentDaoX daoX) {
        this.daoX = daoX;
    }
    public List<Student>  readAll(){
        return  daoX.readAll();
    }
    public Student selectStudent(Long id){
        return daoX.selectStudent(id);
    }
    public void createStudent(Student student){
        daoX.create(student);
    }
    public void deleteStudent(Long id){
        daoX.delete(id);
    }
    public void updateStudent(Student student){
        daoX.update(student);
    }
}
