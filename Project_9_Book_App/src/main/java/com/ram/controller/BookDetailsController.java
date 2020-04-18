package com.ram.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ram.model.BookDetails;
import com.ram.service.BookDetailsService;

import lombok.NoArgsConstructor;

@Controller
@NoArgsConstructor
public class BookDetailsController {

	@Autowired
	private BookDetailsService bookDetailsService;

	@GetMapping(value = "/home")
	public String loadFrom(Model model) {
		model.addAttribute("book", new BookDetails());
		return "book";
	}

	@PostMapping(value = "/saveBook")
	public String saveBookDetails(@ModelAttribute("book") BookDetails bookInfo, Model model) {
		boolean saveBook = bookDetailsService.saveBook(bookInfo);
		if (saveBook) {
			model.addAttribute("successMsg", "Book Stored Successfully !!");
		} else {
			model.addAttribute("errorMsg", "Book Not Stored !!");
		}
		return "book";
	}

	@GetMapping(value = "/getAllBook")
	public String getAllActive(Model model) {
		List<BookDetails> allActive = bookDetailsService.getAllActive();
		model.addAttribute("allBook", allActive);
		return "allBook";
	}

	@GetMapping(value = "/updateBook/{bookId}")
	public String updateBookDetail(@PathVariable ("bookId") Integer bookId, Model model) {
		BookDetails bookById = bookDetailsService.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}
	
	

	@GetMapping(value = "/deleteBook")
	public String deleteBookDetails(@RequestParam("bookId") Integer bookId, RedirectAttributes attr) {
		boolean deleteBook = bookDetailsService.deleteBook(bookId);
		if (deleteBook) {
			attr.addFlashAttribute("successMessage", "Book Deleted Succssfully...");
		}
		return "redirect:/getAllBook";
	}

}
