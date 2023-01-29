package com.blog.blog.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name" ,nullable = false ,length = 100)
    private String name;

    @Column(name = "email",unique = true,nullable = false,length = 30)
    private String email;

    @Column(name = "password" ,nullable = false,length = 16)
    private String password;

    @Column(name = "about",nullable = false)
    private String about;

    private boolean enabled = false;
}