package com.lib.litron10release.DAO;

import com.lib.litron10release.entity.Task;

import java.util.List;

public interface TaskDAO extends GeneralDAO<Task> {
    // поиск топовых задач
    List<Task> findTopTasks(int limit);

}
