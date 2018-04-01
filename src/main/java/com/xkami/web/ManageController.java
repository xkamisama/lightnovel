package com.xkami.web;

import com.xkami.model.Book;
import com.xkami.model.Message;
import com.xkami.service.BookService;
import com.xkami.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/manage")
public class ManageController {
    @Resource
    BookService bookService;
    @Resource
    MessageService messageService;
    @RequestMapping("/bookCheckList")
    public String bookCheckList(Model model){
        model.addAttribute("bookList",bookService.findAllByState(new Byte("0")));
        return "bookCheckList";
    }
    @RequestMapping("/bookCheckDetail/{id}")
    public String bookCheckDetail(@PathVariable Long id,Model model){
        model.addAttribute("book",bookService.findBookById(id));
        return "bookCheckDetail";
    }
    @RequestMapping("/bookCheck/{bookId}/{result}")
    public String bookCheck(@PathVariable Long bookId,@PathVariable String result){
        Book book = bookService.findBookById(bookId);
        if("1".equals(result)){
            book.setState(new Byte(result));
            bookService.save(book);
            String messageContent = "您的小说"+book.getTitle()+"已通过审核";
            Message message = new Message(book.getAuthor().getUser(),new Date(),messageContent,new Byte("0"));
            messageService.save(message);
        }else if("2".equals(result)){
            book.setState(new Byte(result));
            bookService.save(book);
            String messageContent = "您的小说"+book.getTitle()+"未通过审核";
            Message message = new Message(book.getAuthor().getUser(),new Date(),messageContent,new Byte("0"));
            messageService.save(message);
        }
        return "redirect:/manage/bookCheckList";
    }
}
