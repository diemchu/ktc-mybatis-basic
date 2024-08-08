package com.example.crud_mybatis;

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

}
