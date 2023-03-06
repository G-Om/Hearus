package com.example.hearus.Controller;


import com.example.hearus.Entity.UserDetails;
import com.example.hearus.ServiceImpl.LoginRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hearus")
public class LoginController {


    private final LoginRegisterServiceImpl service;

    @Autowired
    public LoginController(LoginRegisterServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(path = "/login")
    String login(){
        return "redirect:/hearus/login/new";
    }


    @RequestMapping(value = "/login/new", method = RequestMethod.GET)
    String loginAttribute(Model model){
        UserDetails user = new UserDetails();
        model.addAttribute("user",user);
        return "login";
    }

    @PostMapping(value = "/login/post")
    public String loginUser(@ModelAttribute("user") UserDetails user){
        UserDetails userAuthenticated = service.authUser(user);
        if(userAuthenticated != null){
            // TODO: Return to the unique link of the logged in user
            return "redirect:/hearus/home/"+userAuthenticated.getId();
        }
        return "login";

    }
}
