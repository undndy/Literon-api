package com.lib.litron10release.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@Entity
@Embeddable
public class Poem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(nullable = false)
    private Author author;

    private String namePoem;

    @Column(nullable = false)
    private String text;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poem")
    private Set<Task> tasks;

    @Override
    public String toString() {
        return namePoem;
    }

}
