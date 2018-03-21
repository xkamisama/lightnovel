package com.xkami.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xkami.model.Author;
import com.xkami.model.User;
import com.xkami.service.AuthorService;
import com.xkami.service.EmailService;
import com.xkami.service.RoleService;
import com.xkami.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UserController {
    @Resource
    UserService userService;
    @Resource
    RoleService roleService;
    @Resource
    EmailService emailService;
    @Resource
    AuthorService authorService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/register")
    public String registerShow(User user){
        return "register";
    }
    @RequestMapping("/register/add")
    public String register(@Valid User user, BindingResult bindingResult)throws IOException{
        System.out.println("register");
        //String json = objectMapper.writeValueAsString(user);
        //return json;
        if(!bindingResult.hasFieldErrors("username")){
            if(userService.countByUsername(user.getUsername())>0){
                bindingResult.addError(new FieldError("user","username","该用户名已被使用"));
            }
        }
        if(!bindingResult.hasFieldErrors("email")){
            if(userService.countByEmail(user.getEmail())>0){
                bindingResult.addError(new FieldError("user","email","该邮箱已被使用"));
            }
        }
        if(bindingResult.hasErrors()){
            return "register";
        }else{
            System.out.println("test");
            user.setRole(roleService.findById(new Long(2)));
            DefaultHashService hashService = new DefaultHashService();
            String salt = UUID.randomUUID().toString().substring(0,3);
            user.setSalt(salt);
            HashRequest request = new HashRequest.Builder().setAlgorithmName("MD5").
                    setSource(ByteSource.Util.bytes(user.getPassword())).setSalt(ByteSource.Util.bytes(user.getCredentialsSalt())).
                    setIterations(2).build();
            user.setPassword(hashService.computeHash(request).toHex());
            userService.save(user);
            //发送邮件验证邮箱完成注册
            emailService.sendSimpleMail(user.getEmail(),"欢迎加入轻小说之家","点击下方链接完成注册 http://localhost:8080/register/confirmEmail/"+user.getPassword());
            return "redirect:/login";
        }

    }
    @RequestMapping("/register/confirmEmail/{token}")
    @ResponseBody
    public String confirmEmail(@PathVariable String token){
        String message = "激活失败";
        if(!"".equals(token)){
            User user = userService.findByPassword(token);
            if(user!=null){
                user.setState(new Byte("1"));
                userService.save(user);
                message = "激活成功";
            }
        }
        return message;
    }
    @RequestMapping("/author/registerPage")
    public String authorRegisterPage(){
        return "authorRegister";
    }
    @RequestMapping("/author/register")
    public String authorAdd(Author author){
        User user =(User)SecurityUtils.getSubject().getPrincipal();
        if(user.getRole().getDescription().equals("作者")){

            return "authorRegister";
        }
        user.setRole(roleService.findById(new Long(3)));
        userService.save(user);
        author.setUser(user);
        authorService.addAuthor(author);
        return "redirect:/logout";
    }
}
