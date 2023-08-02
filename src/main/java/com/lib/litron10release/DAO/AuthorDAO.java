package com.lib.litron10release.DAO;

import com.lib.litron10release.entity.Author;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AuthorDAO extends GeneralDAO<Author> {
    Author save(Author author, MultipartFile multipartFile) throws IOException;

}
