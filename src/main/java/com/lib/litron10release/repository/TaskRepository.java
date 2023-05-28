package com.lib.litron10release.repository;

import com.lib.litron10release.entity.Poem;
import com.lib.litron10release.entity.Task;
import com.lib.litron10release.entity.UserLiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByPoemAndUserLiter(Poem poem, UserLiter userLiter);

    List<Task> findTaskByUserLiter(UserLiter userLiter);
}
