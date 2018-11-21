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
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.domain.dto.RegisterDto;
import pl.coderslab.demo.domain.dto.ServerDto;
import pl.coderslab.demo.security.CurrentUser;
import pl.coderslab.demo.service.ServerService;
import pl.coderslab.demo.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController { //strefa chroniona skonfigurowana w SecurityConfig

    @Autowired
    ServerService serverService;
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(@AuthenticationPrincipal CurrentUser user, Model model){
        model.addAttribute("user",user.getUser());
        return "index";
    }

    @RequestMapping(value = "/newserver", method = RequestMethod.GET)
    public String createNewServer(Model model) {
        model.addAttribute("dto", new ServerDto());
        return "/newserver";
    }

    @RequestMapping(value = "/newserver", method = RequestMethod.POST)
    public String cereateNewServer(@ModelAttribute("dto") @Valid ServerDto dto, BindingResult result)
            throws RegisterFailedException {
        if(result.hasErrors() ){
            System.out.println("nie można dodać nowego serwara");
        }
        serverService.registerServer(dto);
        return "index";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerNewUser(Model model){
        model.addAttribute("dto", new RegisterDto());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("dto") @Valid RegisterDto dto, BindingResult result){
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
}
