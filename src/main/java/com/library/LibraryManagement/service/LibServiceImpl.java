package com.library.LibraryManagement.service;

import com.library.LibraryManagement.entities.LibEntity;
import com.library.LibraryManagement.repository.LibRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class LibServiceImpl implements LibService{

    @Autowired
    LibRepo librepo;

    public List<LibEntity> info= new ArrayList<>();

    @PostConstruct
    public void init(){
        LibEntity Book1 = new LibEntity(12,"Harry Potter", "Fantasy Literature", "J.K Rowling");
        info.add(Book1);
        System.out.println("Intialised Book Details:" + info);
    }

    @Override
    public List<LibEntity> getAllBooks(){
        return info;
    }

    @Override
    public LibEntity createBooks(LibEntity Book){
        return librepo.save(Book);
    }

    @Override
    public LibEntity updateBook(LibEntity Book){
        for(int i=0; i<info.size();i++){
            LibEntity preBook = info.get(i);
            if(preBook.getBookId() == Book.getBookId()){
                info.set(i,Book);
                return Book;
            }
        }
        return null;
    }

    @Override
    public LibEntity deleteBook(LibEntity todeleteBook){
        LibEntity removedBook = null;
        for(int i=0; i<info.size();i++){
            LibEntity preBook = info.get(i);
            if(preBook.getBookId() == todeleteBook.getBookId()){
                removedBook = todeleteBook;
                info.remove(i);
                break;
            }
        }
        return removedBook;
    }
}
