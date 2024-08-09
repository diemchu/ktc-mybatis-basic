package com.example.crud_mybatis;

import com.example.crud_mybatis.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

//MyBatis는 interface의 메서드  sql문을 실행한다.
@Mapper
public interface StudentMapper
{
    @Select("SELECT * FROM STUDENT")
    List<Student> selectStudentAll();
    //여러가지 anotation 통해
    // 다양한 sql문을 실행할 수 있다.

    @Insert("INSERT INTO STUDENT(NAME,EMAIL,AGE,PHONE) " +
            "VALUES(#{name},#{email},#{age},#{phone});")
    void insertStudent(Student student);

    @Select("SELECT * FROM STUDENT WHERE ID = #{ID};")
    Student selectStudent(Long id);

    @Update("""
            UPDATE STUDENT SET 
            NAME = #{name},
            EMAIL = #{email},
            AGE  = #{age},
            PHONE = #{phone} WHERE ID = #{id}            
            """)
    void updateStudent(Student student);

    @Delete("""
            DELETE FROM STUDENT WHERE ID = #{id}
            """)
    void deleteStudent(Long id);

    @Select("""
            Select * from student where id= #{id}
            """)
    Student selectOne(Long id);
}
