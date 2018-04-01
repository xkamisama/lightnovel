package com.xkami.web;

import com.xkami.model.Book;
import com.xkami.model.Category;
import com.xkami.service.BookService;
import com.xkami.service.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("/read")
public class ReadController {
    @Resource
    BookService bookService;
    @Resource
    CategoryService categoryService;
    @RequestMapping("/bookDetail/{bookId}")
    public String bookDetail(@PathVariable Long bookId,Model model){
        model.addAttribute("book",bookService.findBookById(bookId));
        return "bookDetail";
    }
    @RequestMapping("/category/{id}/{page}")
    public String findBookByCategory(@PathVariable Long id, @PathVariable int page,Model model){
        Category category = new Category();
        category.setId(id);
        Pageable pageable = new PageRequest(page,6);
        model.addAttribute("categoryList",categoryService.findAllByAvailable(true));
        List<Book> bookList = bookService.findBooksByCategoryAndState(category,new Byte("1"),pageable);
        model.addAttribute("bookList",bookList);
        model.addAttribute("category",category);
        return "category";
    }
}
