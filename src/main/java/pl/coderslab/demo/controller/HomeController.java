package pl.coderslab.demo.controller;

import com.sun.deploy.association.RegisterFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.demo.domain.Player;
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.domain.dto.RegisterDto;
import pl.coderslab.demo.security.CurrentUser;
import pl.coderslab.demo.service.PlayerService;
import pl.coderslab.demo.service.UserService;

import javax.persistence.ManyToMany;
import javax.validation.Valid;

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
    
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(){
        playerService.readAndSave();
        return "home";
    }

    @RequestMapping(value = "/admin/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("dto", new RegisterDto());
        return "register";
    }

    @RequestMapping(value = "/admin/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("dto") @Valid RegisterDto dto, BindingResult result){
        User user=null;
        if(!result.hasErrors() ){
            try {
                user=userService.registerUser(dto);
            }catch (RegisterFailedException e){
                return "register";
            }
            if(user!=null) {
                return "redirect:/home";
            }
        }
        return "register";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginPost(@Valid LoginDto dto,BindingResult result){
//
//        return "login/index";
//    }




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
