package com.library.LibraryManagement.repository;

import com.library.LibraryManagement.entities.LibEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface LibRepo extends JpaRepository<LibEntity, Integer> {
}
