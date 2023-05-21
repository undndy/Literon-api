package com.lib.litron10release.dto;

import com.lib.litron10release.entity.Poem;
import com.lib.litron10release.entity.UserLiter;
import lombok.Value;

import javax.persistence.*;
import java.util.List;

@Value
public class TaskDTO {
    Long id;
    Poem poem;
    UserLiter userLiter;
}
