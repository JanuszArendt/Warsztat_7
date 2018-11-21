package pl.coderslab.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.demo.security.CurrentUser;
import pl.coderslab.demo.service.PlayerService;
import pl.coderslab.demo.service.UserService;

@Controller
public class HomeController { //kontroller gdzie do endpointów dostęp mają niezalogowani użytkownicy

    @Autowired
    UserService userService;

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping("/home")
    public String home(@AuthenticationPrincipal CurrentUser user, Model model){
        model.addAttribute("user",user.getUser());
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(){
        return "register";
    }

    @RequestMapping(value = "/404",method = RequestMethod.GET)
    public String print404(){
        return "404";
    }
    @RequestMapping(value = "/blank",method = RequestMethod.GET)
    public String blank(){
        return "blank";
    }

}
