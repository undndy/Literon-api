package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.FileItem;
import com.lib.litron10release.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    private FileItem toFileEntity(MultipartFile image) throws IOException {
        FileItem fileItem = new FileItem();
        fileItem.setName(image.getName());
        fileItem.setContentType(image.getContentType());
        fileItem.setImageBytes(image.getBytes());
        fileItem.setOriginalFileName(image.getOriginalFilename());
        return fileItem;
    }

    public FileItem save(MultipartFile state) throws IOException {
        FileItem file = toFileEntity(state);
        return fileRepository.save(file);
    }

    @Transactional
    public List<FileItem> getAllState(){
        return fileRepository.findAllByName("state");
    }
}
