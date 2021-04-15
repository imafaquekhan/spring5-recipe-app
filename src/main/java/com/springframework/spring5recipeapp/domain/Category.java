package com.springframework.spring5recipeapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"}) // to solve hashcode loop error
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    // mapped by categories property on Recipe, which will be on join table
    @ManyToMany(mappedBy="categories")
    private Set<Recipe> recipes;

}
