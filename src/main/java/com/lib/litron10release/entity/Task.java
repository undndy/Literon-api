package com.lib.litron10release.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Poem poem;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private List<Question> questions;

//    @ManyToOne
//    private User user;
}
