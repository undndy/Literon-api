package com.lib.litron10release.dto;

import com.lib.litron10release.entity.Chronograph;
import com.lib.litron10release.entity.Poem;
import lombok.Value;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Value
public class AuthorDTO {
    Long id;
    String firstName;
    String lastName;
    String patronymic;
    String description;
    List<Chronograph> chronograph;
    Set<Poem> poems;
    Date dateBirth;
    Date dateDeath;
}
