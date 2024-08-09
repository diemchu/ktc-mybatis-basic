package com.example.crud_mybatis.mapper;

import com.example.crud_mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDaoX
{
    private  final SqlSessionFactory sessionFactory;

    public StudentDaoX(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Student> readAll(){
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapperX = session.getMapper(StudentMapperX.class);
            return mapperX.selectStudentAll();
        }
    }
    public  Student selectStudent(Long id){
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapperX = session.getMapper(StudentMapperX.class);
            return mapperX.selectStudent(id);
        }
    }
    public  void create(Student student){
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapperX = session.getMapper(StudentMapperX.class);
            mapperX.createStudent(student);
        }
    }
    public void delete(Long id){
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapperX  = session.getMapper(StudentMapperX.class);
            mapperX.deleteStudent(id);
        }
    }
    public void update(Student student){
        try(SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapperX = session.getMapper(StudentMapperX.class);
            mapperX.updateStudent(student);
        }
    }
}
