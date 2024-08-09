package com.example.crud_mybatis.model;

import lombok.*;

@Data //toString
@NoArgsConstructor // non constructor
@AllArgsConstructor // all args constructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private  String phone;
    private String email;

    public Student(String name, String email,int age ,String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
}
