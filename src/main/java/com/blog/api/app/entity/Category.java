package com.blog.api.app.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "category")
@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;



    @Column(name = "Title", nullable = false, length = 200)
    private String title;

    @Column(name = "Discription", nullable = false, length = 200)
    private String description;



    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();


}
