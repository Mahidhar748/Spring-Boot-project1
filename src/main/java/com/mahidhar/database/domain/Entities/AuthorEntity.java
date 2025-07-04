package com.mahidhar.database.domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
    //I commented @GeneratedValue due to it is creating exception when we are giving value directly
    private Long id;
    private String name;
    private Integer age;


}
