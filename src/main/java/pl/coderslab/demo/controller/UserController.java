package pl.coderslab.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.demo.domain.Player;
import pl.coderslab.demo.domain.Setings;
import pl.coderslab.demo.domain.dto.SearchDto;
import pl.coderslab.demo.service.PlayerService;
import pl.coderslab.demo.service.ServerService;
import pl.coderslab.demo.service.SetingsService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    PlayerService playerService;
    @Autowired
    ServerService serverService;
    @Autowired
    SetingsService setingsService;

    @RequestMapping(value = "/servers", method = RequestMethod.GET)
    public String serversAll(Model model){
        model.addAttribute("servers", serverService.findAllServers());
        return "servers";
    }

    @RequestMapping("/del/{id}")
    public String deleteServer(@PathVariable long id) {
        serverService.deleteServer(id);
        return "redirect:/user/servers";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPlayer(Model model){
        model.addAttribute("player", new Player());
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPlayer(@Valid SearchDto dto, BindingResult result, Model model){
        model.addAttribute("result", playerService.findPlayersByName(dto.getName()));
        return "resultsearch";
    }  //todo co z BindingResult ?

    @RequestMapping(value = "/ban/{id}")
    public String ban(@PathVariable long id){
        playerService.banPlayer(id);
        return "redirect:/user/banlist";
    }

    @RequestMapping(value = "/banlist", method = RequestMethod.GET)
    public String banlist(Model model) {
        model.addAttribute("ban", playerService.playerBanList());
        return "banlist";
    }

    @RequestMapping("/delbanlist/{id}")
    public String delbanlist(@PathVariable long id){
        playerService.delBanPlayer(id);
        return "redirect:/user/banlist";
    }

    @RequestMapping("savebanlist")
    public String savebanlist(){
        playerService.saveBanList();
        return"redirect:/";
    }

    @RequestMapping(value = "/seting", method = RequestMethod.GET)
    public String setingAdd(Model model){
        model.addAttribute("seting", new Setings());
        return "seting";
    }

    @RequestMapping(value = "/seting", method = RequestMethod.POST)
    public String setingAdd( @Valid Setings set, BindingResult result, Model model){
        setingsService.seve(set);
        return "/home";
    }

    @RequestMapping(value = "/allsetings", method = RequestMethod.GET)
    public String allSetings(Model model) {
        model.addAttribute("set", setingsService.allSetingsList());
        return "allsetings";
    }

    @RequestMapping("/set/{id}")
    public String changeSettings(@PathVariable long id) {
        setingsService.changeSeting(id);
        return "redirect:/user/allsetings";
    }

    @RequestMapping("savesetings")
    public String savesetings(){
        setingsService.saveAllSetings();
        return"redirect:/";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(){
        playerService.readAndSave();
        return "home";
    }



}
