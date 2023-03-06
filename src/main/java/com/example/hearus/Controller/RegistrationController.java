package com.example.hearus.Controller;

import com.example.hearus.Entity.UserDetails;
import com.example.hearus.ServiceImpl.LoginRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hearus")
public class RegistrationController {

    private final LoginRegisterServiceImpl service;

    @RequestMapping("/register")
    public String register(){return "redirect:/hearus/register/new";};

    @Autowired
    public RegistrationController(LoginRegisterServiceImpl service) {
        this.service = service;
    }

    // Create Empty user object
    @GetMapping(value = "/register/new")
    public String registerAttribute(Model model){
        UserDetails userRegister = new UserDetails();
        model.addAttribute("userReg",userRegister);
        return "register";
    }
//  Register user with previous object created
    @PostMapping("/register/post")
    public String registerUser(@ModelAttribute("userReg") UserDetails user){
        System.out.println(user.toString());
        if(service.saveUser(user)!=null){
            return "redirect:/hearus/Emergency/"+user.getId();
        }else {
            return "register";
        }
    }


}
