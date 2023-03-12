package com.apitest.ApiTest.Controller;

import com.apitest.ApiTest.Entity.User;
import com.apitest.ApiTest.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveData(@ModelAttribute("userdata")User user, Model m){
        user.setStatus("Saved");
        userRepo.save(user);

        return "redirect:/home";
    }


    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public String cancelData(@ModelAttribute("userdata")User user, Model m){
        user.setStatus("Canceled");
        userRepo.save(user);

        return "redirect:/home";
    }
}
