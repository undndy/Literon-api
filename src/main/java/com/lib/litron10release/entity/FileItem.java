package com.lib.litron10release.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "originalFileName")
    private String originalFileName;

    @Column(name = "contentType")
    private String contentType;

    @Lob
    private byte[] imageBytes;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Author author;

}
