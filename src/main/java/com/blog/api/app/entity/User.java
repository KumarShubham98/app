package com.blog.api.app.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "Name",length = 200)
    private String name;
    @Column(name = "Email",nullable = false,length = 200)
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "About")
    private String about;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();





}
