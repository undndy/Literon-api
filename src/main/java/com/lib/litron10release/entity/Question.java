package com.lib.litron10release.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Task task;

    private String text;

}
