package com.lib.litron10release.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@Entity
@Embeddable
public class Chronograph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String year;

    @Column
    private String text;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Author author;
}
