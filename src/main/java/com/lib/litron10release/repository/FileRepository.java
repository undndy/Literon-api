package com.lib.litron10release.repository;

import com.lib.litron10release.entity.FileItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileItem, Long> {
     List<FileItem> findAllByName(String state);
}
