package com.lib.litron10release.dto;

import com.lib.litron10release.entity.Task;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UserDTO {

    private Long id;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    private String email;
    private Long role;
    private List<Task> task;
}
