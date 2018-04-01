package com.xkami.web;


import com.xkami.model.Message;
import com.xkami.model.User;
import com.xkami.service.MessageService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Resource
    MessageService messageService;
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
    @RequestMapping("/test")
    public String Epub() {
        return "test";
    }
    @RequestMapping("/top")
    public String top(Model model){


        User user =(User) SecurityUtils.getSubject().getPrincipal();

        model.addAttribute("messageCount",messageService.countAllByUserAndState(user,new Byte("0")));
        return "top";
    }
    @RequestMapping("/menu")
    public String menu(){
        return "menu";
    }
    @RequestMapping("/manage")
    @RequiresRoles("管理员")
    public String manage(){
        return "manage";
    }
    @RequestMapping("/message")
    public String message(){
        return "message";
    }
    @RequestMapping("/message/{state}/{page}")
    public String messageList(@PathVariable byte state,@PathVariable int page,Model model){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        Pageable pageable = new PageRequest(page,10);
        List<Message> messageList=messageService.findAllByUserAndState(user,state,pageable);

        model.addAttribute("messageList",messageList);
        return "messageList";
    };
    @RequestMapping("/message/changeState/{messageId}/{state}")
    public String changeMessageState(@PathVariable Long messageId,@PathVariable byte state){
        Message message = messageService.findById(messageId);
        message.setState(state);
        messageService.save(message);
        return "redirect:/message/0/0";
    }

}