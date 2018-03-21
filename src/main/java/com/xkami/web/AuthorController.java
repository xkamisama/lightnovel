package com.xkami.web;

import com.xkami.model.Book;
import com.xkami.model.User;
import com.xkami.service.AuthorService;
import com.xkami.service.BookService;
import com.xkami.service.CategoryService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Value("${book.filePath}")
    private String filePath;
    @Resource
    BookService bookService;
    @Resource
    CategoryService categoryService;
    @Resource
    AuthorService authorService;
    @RequestMapping("/authorHome")
    public String authorHome( ){
        return "authorHome";
    };
    @RequestMapping("/createBookPage")
    public String createBookPage(Model model){
        model.addAttribute("categoryList",categoryService.findAllByAvailable(true));
        return "createBook";
    }
    @RequestMapping("/createBook")
    public String createBook(Book book,@RequestParam("file") MultipartFile file,HttpServletRequest request){
        System.out.println("createBook");

        System.out.println(filePath+"post//");
        if (!file.isEmpty()) {
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 文件上传后的路径
//        String filePath = "E://test//";
            // 解决中文问题，liunx下中文路径，图片显示问题
            // fileName = UUID.randomUUID() + suffixName;
            File dest = new File(filePath+"post//" + fileName);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                book.setPostUrl("/static/post"+fileName);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        book.setDate(new Date());
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        book.setAuthor(authorService.findAuthorBy(user));
        bookService.save(book);
       return "authorHome";

    }
}
