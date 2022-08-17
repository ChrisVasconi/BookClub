package com.chrisvasconi.loginreg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisvasconi.loginreg.models.Books;

import com.chrisvasconi.loginreg.repositories.BookRepo;


@Service
public class BooksService {

    @Autowired
    private BookRepo booksRepo;
	
	//Find all
    public List<Books> allBooks(){
    	return booksRepo.findAll();
    }
    //Find one
    public Books oneBooks(Long id) {
    	Optional<Books> optionalBooks = booksRepo.findById(id);
    	if(optionalBooks.isPresent()) {
    		return optionalBooks.get();
    	}else {
    		return null;
    	}
    }
    //Create
    public Books createBooks(Books books) {
    	return booksRepo.save(books);
    }
    
    
    //Update
    public Books updateBooks(Books books) {
    	return booksRepo.save(books);
    }
    
    //DELETE
    public void deleteBook(Long id) {
    	booksRepo.deleteById(id);
    }
    
}
