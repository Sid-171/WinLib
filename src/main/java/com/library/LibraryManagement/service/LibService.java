package com.library.LibraryManagement.service;

import com.library.LibraryManagement.entities.LibEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibService {

    List<LibEntity> getAllBooks();

    LibEntity createBooks(LibEntity Book);

    LibEntity updateBook(LibEntity Book);

    LibEntity deleteBook(LibEntity Book);
}
