package com.chrisvasconi.loginreg.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.chrisvasconi.loginreg.models.Books;
import com.chrisvasconi.loginreg.models.LoginUser;
import com.chrisvasconi.loginreg.models.User;
import com.chrisvasconi.loginreg.services.BooksService;
import com.chrisvasconi.loginreg.services.UserService;

@Controller
public class HomeController {
	  // Add once service is implemented:
     @Autowired
     private UserService userService;
     @Autowired
     private BooksService booksService;
     
     //============LOGIN and REG=========
     //======Render that login form====
    @GetMapping("/")
    public String renderLogReg(Model model) {
    	model.addAttribute("newUser", new User());
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
    	model.addAttribute("newLogin", new LoginUser());
        return "logregform.jsp";
    }
    
    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        userService.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "logregform.jsp";
        }
        
        session.setAttribute("userId", newUser.getId()); 
    	return "redirect:/dashboard";
    }
    
    @PostMapping("/login") 
    public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	User user = userService.login(newLogin, result);
    	
    	if(result.hasErrors()) {
    		model.addAttribute("newUser", new User());
    		return "logregform.jsp";
    	}
    	session.setAttribute("userId", user.getId());
    	return "redirect:/dashboard";
    }
    
  //==================LOGOUT============
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
 //==================Dashboard============
    @GetMapping("/dashboard")
    public String allBooks(HttpSession session, Model model) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	List<Books> booksList = booksService.allBooks();
    	model.addAttribute("booksList", booksList);
    	return "dashboard.jsp";
    }
       
  //==================Create============
    //Render the form
    @GetMapping("/books/new")
    public String renderCreateBooks(@ModelAttribute("books")Books books) {
		return "createbook.jsp";
    	
    }
    //process the form
    @PostMapping("/books/new")
    public String processCreateBook(@Valid @ModelAttribute("books")Books books, BindingResult result) {
    	if(result.hasErrors()) {
    		return "createbook.jsp";
    	}else {
    		booksService.createBooks(books);
    		return "redirect:/dashboard";
    	}
    	
    }
    
    //=================EDIT=============
    
    @GetMapping("/books/edit/{id}")
    public String renderEditBook(@PathVariable("id")Long id, Model model ) {
    	model.addAttribute("books", booksService.oneBooks(id));
    	return "edit.jsp";
    }
    
    @PutMapping("/books/edit/{id}")
    public String processEditBook(@Valid @ModelAttribute("books")Books books, BindingResult result) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}else {
    		booksService.updateBooks(books);
    		return "redirect:/dashboard";
    	}
    
    }
    
    //===============Delete=================
    @DeleteMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id")Long id) {
		booksService.deleteBook(id);
    	return "redirect:/dashboard";
    	
    }
    
    
    //==================== Find one ====================
    @GetMapping("/books/{id}")
    public String oneBooks (@PathVariable("id")Long id, Model model) {
    	model.addAttribute("books", booksService.oneBooks(id));
    	return "description.jsp";
    }
    
    
}




