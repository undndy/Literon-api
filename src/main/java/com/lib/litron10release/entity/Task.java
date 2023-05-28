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

    @ManyToOne
    @JoinColumn(name = "poem_id")
    @JsonBackReference // Используйте эту аннотацию для предотвращения бесконечной рекурсии при сериализации
    private Poem poem;

    @Column
    private String type;

    @Column
    private String text;

    @Column
    private String optionText;

    @Column
    private String question1;

    @Column
    private String question2;

    @Column
    private String question3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_liter_id")
    @JsonIgnore // Используйте эту аннотацию, чтобы игнорировать свойство userLiter при сериализации
    private UserLiter userLiter;
}
