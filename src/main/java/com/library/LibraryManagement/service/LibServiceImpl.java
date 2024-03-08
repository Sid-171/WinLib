package com.library.libraryManage.service;
import com.library.libraryManage.controller.Lib;
import com.library.libraryManage.entity.Info;
import com.library.libraryManage.repository.LibRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class LibInfoImpl implements LibInfo {

    @Autowired
    LibRepo librepo;
    public List<Info> info = new ArrayList<>();

    @PostConstruct
    public void init() {
        Info Book1 = new Info(12, "Harry Potter", "Thriller", "J.K Rowling");
        info.add(Book1);
        System.out.println("Initialised Book Details:" + info);
    }

    @Override
    public List<Info> getAllBooks() {
        return info;
    }

    @Override
    public Info createBooks(Info Book1) {
        return librepo.save(Book1);
    }

    @Override
    public Info updateBook(Info Book2) {
        for (int i = 0; i < info.size(); i++) {
            Info preBook = info.get(i);
            if (preBook.getBookId() == Book2.getBookId()) {
                info.set(i, Book2);
                return Book2;
            }
        }
        return null;
    }

    @Override
    public Info deleteBook(Info Book3) {
        Info removedBook = null;
        for (int i = 0; i < info.size(); i++) {
            Info Book = info.get(i);
            if (Book.getBookId() == Book3.getBookId()) {
                removedBook = Book;
                info.remove(i);
                break;
            }
        }
        return removedBook;
    }
}
