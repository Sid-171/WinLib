package com.library.libraryManage.controller;

import com.library.libraryManage.entity.Info;
import com.library.libraryManage.repository.LibRepo;
import com.library.libraryManage.service.LibInfo;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lib")
public class Lib {
    @Autowired
    LibRepo librepo;

    @Autowired
    private LibInfo libinfo;

    @GetMapping("/getAllBooks")
    public List<Info> getAllBooks(){
        return libinfo.getAllBooks();
    }

    @PostMapping("/createBooks")
    public Info createBooks(@RequestBody Info Book1){
        return librepo.save(Book1);
    }

    @PostMapping("/updateBook")
    public Info updateBook(@RequestBody Info Book1){
        return libinfo.updateBook(Book1);
    }

    @DeleteMapping("/deleteBook")
    public Info deleteBook(@RequestBody Info Book1){
        return libinfo.deleteBook(Book1);
    }
}
