package com.example.crud_mybatis.mapper;
import com.example.crud_mybatis.StudentDao;
import com.example.crud_mybatis.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapperX {
    List<Student> selectStudentAll();
    Student selectStudent(Long id);
    void createStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Student student);
}
