package com.lib.litron10release.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@Entity
@Embeddable
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "text")
    private String Chronogrof;

//    @Column(name = "image_url")
//    private FileItem photo;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Poem> poems;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date dateBirth;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date dateDeath;

    @Override
    public String toString() {
        return patronymic;
    }
}
