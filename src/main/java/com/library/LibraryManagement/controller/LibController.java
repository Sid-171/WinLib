package com.library.LibraryManagement.controller;

import com.library.LibraryManagement.entities.LibEntity;
import com.library.LibraryManagement.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.library.LibraryManagement.repository.LibRepo;

import java.util.List;

@RestController
@RequestMapping("/lib")
public class LibController {
    @Autowired
    LibRepo librepo;

    @Autowired
    private LibService libinfo;

    @GetMapping("/getAllBooks")
    public List<LibEntity> getAllBooks(){
        return libinfo.getAllBooks();
    }

    @PostMapping("/createBooks")
    public LibEntity createBooks(@RequestBody LibEntity Book1){
        return librepo.save(Book1);
    }

    @PostMapping("/updateBook")
    public LibEntity updateBook(@RequestBody LibEntity Book1){
        return libinfo.updateBook(Book1);
    }

    @DeleteMapping("/deleteBook")
    public LibEntity deleteBook(@RequestBody LibEntity Book1){
        return libinfo.deleteBook(Book1);
    }
}
