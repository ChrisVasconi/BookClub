package com.chrisvasconi.loginreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chrisvasconi.loginreg.models.Books;

public interface BookRepo extends CrudRepository<Books, Long>{

	List<Books> findAll();
}
