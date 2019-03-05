package com.marom.recipe.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(exclude = {"recipe"})
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

}
