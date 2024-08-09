package com.example.crud_mybatis;

import com.example.crud_mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

//db 연결을 활용해
// Mapper interface를 실제로 사용하는 클래스
@Repository
public class StudentDao {
    // db랑 연결하는 역할
    //SqlSessionFactory là một khái niệm trong MyBatis,
    // một framework phổ biến trong Java giúp dễ dàng tương tác với cơ sở
    // dữ liệu theo cách ORM (Object-Relational Mapping) hoặc Semi-ORM.
    //chịu trách nhiệm tạo ra các đối tượng SqlSession
    //Một SqlSession đại diện cho một phiên làm việc với cơ sở dữ liệu,
    // nó cho phép thực thi các câu lệnh SQL, lấy kết quả, quản lý
//    Thông thường, SqlSessionFactory được cấu hình một lần duy nhất trong suốt vòng đời của ứng dụng
//    và có thể được tái sử dụng trong nhiều phiên làm việc với cơ sở dữ liệu
//    Nó đóng vai trò như một "nhà máy" sản xuất các đối tượng SqlSession,
//    từ đó giúp bạn có thể thực hiện các thao tác CRUD (Create, Read, Update, Delete) với cơ sở dữ liệu.
    private final SqlSessionFactory sessionFactory;

    public StudentDao(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public List<Student> readStudentAll() {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.selectStudentAll();
        }
    }
    public  void createStudent(Student student){
        try(SqlSession session = sessionFactory.openSession()){
           StudentMapper mapper = session.getMapper(StudentMapper.class);
           mapper.insertStudent(student);
        }
    }
    public  Student selectStudent(Long id){
        try(SqlSession session = sessionFactory.openSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return mapper.selectStudent(id);
        }
    }

    public  void updateStudent(Student student){
        try(SqlSession session = sessionFactory.openSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.updateStudent(student);
        }
    }

    public void deleteStudent(Long id){
        try(SqlSession session = sessionFactory.openSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.deleteStudent(id);
        }
    }
    public Student selectOneStudent(Long id){
        try(SqlSession session=sessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            return  mapper.selectOne(id);
        }
    }

}
