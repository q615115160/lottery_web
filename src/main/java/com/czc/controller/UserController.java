package com.czc.controller;

import com.czc.bean.User;
import com.czc.service.UserService;
import com.czc.utils.BallUtils;
import com.czc.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * ClassName:UserController
 * Description:
 */

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService mUserService;

    @RequestMapping("/registerUI")
    public String showRegisterUI() {
        return "register";
    }

    @RequestMapping("/register")
    public String doRegister(User user, String code, Model model, HttpSession session) {
        System.out.println("doRegister");

        //1.check sms code
        String registerCode = (String) session.getAttribute("register_code");
        if (code == null || !code.equals(registerCode)) {
            model.addAttribute("msg", "sms code incorrect");
            return "forward:/user/registerUI";
        }

        //2. do register
        // testgit
        user.setState(0);
        user.setUid(UUIDUtils.getId());
        user.setHeadimg("/img/icon.jpg");
//        user.setPassword(MD5Utils.encode(user.getPassword()));

        User registeredUser = mUserService.register(user);

        if (registeredUser != null) {
            //success
            return "redirect:/user/loginUI";
        }
        model.addAttribute("msg", "register fail");
        return "forward:/user/registerUI";


    }

    @RequestMapping("/loginUI")
    public String showLoginUI() {
        return "login";
    }

    @RequestMapping("/login")
    public String doLogin(String email, String password, Model model, HttpSession session) {

        User user = mUserService.findUser(email, password);
        System.out.println("doLogin " + user);
        if (user != null) {
            //success
            //add session
            session.setAttribute("user", user);
            return "redirect:/";
        }
        model.addAttribute("msg", "login fail");
        return "forward:/user/loginUI";
    }

    @ResponseBody
    @RequestMapping("/sendSms")
    public String sendSms(String mobile, HttpSession session) {
//        System.out.println("usercontroller sendSms "+mobile);
        try {
//           String smscode= SMSUtils.sendSms(mobile);
            String smscode = (long) (Math.random() * 1000000) + "";
            //add to session
            System.out.println("usercontroller save smscode " + mobile + ":" + smscode);
            session.setAttribute("register_code", smscode);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

    @RequestMapping("/myUI")
    public String showMy(Model model) {

        List<String> redBalls = BallUtils.randomRed();
        String blue = BallUtils.randomBlue();
        model.addAttribute("redBalls",redBalls);
        model.addAttribute("blue",blue);
        return "my";
    }

}
