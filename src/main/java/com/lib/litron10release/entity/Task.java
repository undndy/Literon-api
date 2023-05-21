package com.lib.litron10release.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Poem poem;

    @Column(nullable = false)
    private String type;

    private String text;
    private String question1;
    private String question2;
    private String question3;


    @ManyToOne(fetch = FetchType.LAZY)
    private UserLiter userLiter;
}
