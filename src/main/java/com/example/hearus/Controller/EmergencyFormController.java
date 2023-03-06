package com.example.hearus.Controller;

import com.example.hearus.Entity.UserDetails;
import com.example.hearus.ServiceImpl.LoginRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hearus")
public class EmergencyFormController {

    private LoginRegisterServiceImpl service;
    private Long id ;

    @Autowired
    public EmergencyFormController(LoginRegisterServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/Emergency/{id}")
    public String assignId(@PathVariable Long id){
        this.id = id;
        return "redirect:/hearus/Emergency/new";
    }
    @RequestMapping("/role/{id}")
    public String role(@PathVariable Long id,Model model){
        UserDetails userDetails = service.getUserById(id);
        model.addAttribute("id",userDetails);
        return "role";
    }

    @GetMapping(value = "/Emergency/new")
    public String emergencyForm(Model model){
        UserDetails user = new UserDetails();
        model.addAttribute("userRel",user);
        return "EmergencyForm";
    }
    @PostMapping(value = "/Emergency/post")
    public String relativeRegister(@ModelAttribute("userRel") UserDetails user){
        System.out.println(user.toString());
        service.update(this.id,user);
        UserDetails updated = service.getUserById(this.id);
        if(updated.getRelativeName() == user.getRelativeName()
                && updated.getRelativeNo() == user.getRelativeNo()){
            return "redirect:/hearus/role/"+updated.getId();
        }else {
            return "redirect:/hearus/Emergency/"+ this.id;
        }
    }


}
