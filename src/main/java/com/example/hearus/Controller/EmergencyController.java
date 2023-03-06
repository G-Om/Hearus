package com.example.hearus.Controller;


import com.example.hearus.Entity.UserDetails;
import com.example.hearus.ServiceImpl.LoginRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/hearus")
public class EmergencyController {

    private LoginRegisterServiceImpl service;
    private String location = "null";

    @Autowired
    public EmergencyController(LoginRegisterServiceImpl service) {
        this.service = service;
    }
    // Method on redirected to emergency page
    // Path variable captures id
    // Model obj used to set thymeleaf object
    @RequestMapping("/emergency/{id}")
    String emergency(@PathVariable Long id, Model model){
        // get the user details from db
        UserDetails user = service.getUserById(id);
        //put the user obj in html page using thymeleaf object model
        model.addAttribute("user",user);
        return "alert";
    }

    @RequestMapping("/help/{id}")
    String help(@PathVariable Long id){
        // get the user details from db
        //UserDetails user = service.getUserById(id);
        //put the user obj in html page using thymeleaf object model
        //model.addAttribute("user",user);
        return "help";
    }

    @PostMapping(value = "/emergency/valid")
    @ResponseBody
    void emergencyValid(@RequestBody String location){
        System.out.println(this.location);
        this.location = location;
    }

    // if emergency is validated send location to Relative
    @RequestMapping(value = "/emergency/fetchL")
    @ResponseBody
    String emergencyLocation(){
        System.out.println(this.location);
        return this.location;
    }

    @RequestMapping("/relative")
    String relative(){
        return "relative";
    }

    



}
