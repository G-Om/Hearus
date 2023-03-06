package com.example.hearus.Controller;

import com.example.hearus.Entity.UserDetails;
import com.example.hearus.ServiceImpl.LoginRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/hearus")
public class ControllerClass {

    private final LoginRegisterServiceImpl service;
    private Long id;

    @Autowired
    public ControllerClass(LoginRegisterServiceImpl service) {
        this.service = service;
    }


    @RequestMapping(path = "/index")
    String index(){
        return "index";
    }
    @RequestMapping(path = "/second")
    String second(){
        return "second";
    }

    @GetMapping(path = "/home/{id}")
    String home(@PathVariable Long id, Model model){
        this.id = id;
        UserDetails userDetails = service.getUserById(id);

        model.addAttribute("user",userDetails);
        return "home";
    }
    @GetMapping(path = "/gps/{id}")
    String gps(@PathVariable Long id, Model model){
        UserDetails userDetails = service.getUserById(id);
        model.addAttribute("id",userDetails);
        return "gps";
    }

    @GetMapping(path = "/device/{id}")
    String device(@PathVariable Long id, Model model){
        UserDetails userDetails = service.getUserById(id);
        model.addAttribute("id",userDetails);
        return "device";
    }

    @GetMapping(path = "/gov/{id}")
    String gov(@PathVariable Long id, Model model){
        UserDetails userDetails = service.getUserById(id);
        model.addAttribute("id",userDetails);
        return "gov";
    }
    @GetMapping(path = "/notification/{id}")
    String notification(@PathVariable Long id, Model model){
        UserDetails userDetails = service.getUserById(id);
        model.addAttribute("id",userDetails);
        return "notification";
    }
    @GetMapping(path = "/inbox/{id}")
    String inbox(@PathVariable Long id, Model model){
        UserDetails userDetails = service.getUserById(id);
        model.addAttribute("id",userDetails);
        return "inbox";
    }
    @GetMapping(path = "/transcribe/{id}")
    String transcribe(@PathVariable Long id, Model model){
        UserDetails userDetails = service.getUserById(id);
        model.addAttribute("id",userDetails);
        return "transcribe";
    }




//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public String registerAttribute(Model model){
//        UserDetails userRegister = new UserDetails();
//        model.addAttribute("userReg",userRegister);
//        return "register";
//    }
//
//    @PostMapping("/register/post")
//    public String registerUser(@ModelAttribute("userReg") UserDetails user){
//        if(service.saveUser(user)!=null){
//            return "Emergency";
//        }else {
//            return "register";
//        }
//    }

    // Get mapping for login object
//    @RequestMapping(value ="/login", method = RequestMethod.GET)
//    @ResponseBody
//    public String createLoginForm(Model model){
//        // create a new user obj to get user login details
//        UserDetails user = new UserDetails();
//        model.addAttribute("user",user);
//        return "login" ;
//    }
//
//    @RequestMapping(value="/login/post", method = RequestMethod.POST)
//    @ResponseBody
//    public void authUser(@ModelAttribute("user") UserDetails user){
//        //Authenticate user
//        if(!service.authUser(user)){
//            service.Login();
//        }else {
//            throw new IllegalStateException("Invalid Details");
//        }
//    }
//    // Get mapping for register object
//    @RequestMapping(value="/register", method = RequestMethod.GET)
//    @ResponseBody
//    public String createRegForm(Model model){
//        //new user object to get user register details
//        UserDetails user = new UserDetails();
//        model.addAttribute("userReg",user);
//        return "register";
//    }
//    @RequestMapping(value ="/register/post",method = RequestMethod.POST)
//    @ResponseBody
//    public void saveUser(@ModelAttribute("userReg") UserDetails user){
//        //Save user
//        service.saveUser(user);
//    }
//
//    @CrossOrigin
//    @PostMapping(value = "/login")
//    public Boolean authenticateUser(@RequestBody UserDetails userDetails){
//        return service.authUser(userDetails);
//    }
//
//
// //  Register User Method
//    @CrossOrigin
//    @PostMapping(value = "/register")
//    public UserDetails register(@RequestBody UserDetails user){
//        System.out.println("Save user called");
//        return service.saveUser(user);
//    }




}
