package com.bookauthor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookauthor.entity.BookAuthorEntity;
import com.bookauthor.service.BookAuthorService;

@Controller
public class BookAuthorController {

	@Autowired
	private BookAuthorService Service;

//	@GetMapping
//	public String defaultmethod() {
//		return "redirect:/allauthors";
//	}

	@GetMapping("/allauthors")
//	@ResponseBody
	public String allAuthorList(Model model) {
		List<BookAuthorEntity> allauthorlist = Service.allAuthorList();
//		for (BookAuthorEntity o : allauthorlist) {
//			System.err.println(o);
//		}
		System.out.println(allauthorlist);
		model.addAttribute("authors", allauthorlist);
		return "allAuthors";

	}
	/*
	 * @PostMapping("/addauthor")
	 *
	 * @ResponseBody public String addAuthor(@RequestBody BookAuthorEntity model) {
	 * Service.addAuthor(model); return "addAuthor"; }
	 */

	@GetMapping("/addauthor")
	public String addAuthor(Model model) {
		BookAuthorEntity bookauthor = new BookAuthorEntity();
		model.addAttribute("author", bookauthor);
//		System.err.println(bookauthor);
		return "addAuthor";
	}

	@PostMapping("/saveauthor")
//	@ResponseBody
	public String saveAuthor(BookAuthorEntity entity) {
//		BookAuthorEntity bookauthor=new BookAuthorEntity();
		/*
		 * // model.addAttribute("author", bookauthor);
		 *
		 * ?authorName=pp&city=pp&state=jj&country=aa&noOfBooksPublished=8&language=
		 * jndjnd
		 */
//		System.out.println(model);
////		if(model.getBookId()==0) {
//		System.out.println(model);
//		System.out.println(entity);
		Service.saveAuthor(entity);

		return "redirect:/allauthors";
	}

//	,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
	@GetMapping("/update")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String updateAuthor(@RequestParam("bookId") int bookid, Model model) {
		BookAuthorEntity ex = Service.findAuthorById(bookid);
//		BookAuthorEntity n=new BookAuthorEntity();
		model.addAttribute("update", ex);
		return "updateAuthor";
	}

	@PostMapping("/updateauthor")
//	@ResponseBody
	public String updateAuthor(BookAuthorEntity entity) {
//		System.out.println(entity);
//		System.err.println(entity.getCreateDate());

//		Service.saveAuthor(entity);
		Service.updateAuthor(entity);

		return "redirect:/allauthors";
	}

	@GetMapping("/delete")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String deleteAuthor(@RequestParam("bookId") int bookid) {
		Service.deleteAuthor(bookid);

		return "redirect:/allauthors";
	}

	//////// cheking data security
	@GetMapping("/data")
	@ResponseBody
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String data() {
		return "checking Data";
	}

//	//add the user detailes
//	@PostMapping("/adduser")
//	@ResponseBody
//	public String adduser(@RequestBody UserInfo userInfo) {
//		return Service.adduser(userInfo);
//	}
	@GetMapping("/test")
	@ResponseBody
	public List<BookAuthorEntity> test() {
		return Service.testing();
	}

	@GetMapping("/by/{authorName}")
	@ResponseBody
	public List<BookAuthorEntity> getbyauthorName(@PathVariable String authorName) {
		List<BookAuthorEntity> o = Service.findbyAuthorName(authorName);
		System.out.println(o);
		return Service.findbyAuthorName(authorName);
	}

	@GetMapping("/api/book/byid/{id}")
	@ResponseBody
	public BookAuthorEntity findbyid(@PathVariable int id, Model model) {
		BookAuthorEntity l = Service.findAuthorById(id);
		model.addAttribute("bookAuthor", l);
		return Service.findAuthorById(id);
	}

}
