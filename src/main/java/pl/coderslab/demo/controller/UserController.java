package pl.coderslab.demo.controller;

import com.sun.deploy.association.RegisterFailedException;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.demo.domain.FtpClient;
import pl.coderslab.demo.domain.Player;
import pl.coderslab.demo.domain.Server;
import pl.coderslab.demo.domain.Setings;
import pl.coderslab.demo.domain.dto.SearchDto;
import pl.coderslab.demo.repository.PlayerRepository;
import pl.coderslab.demo.repository.ServerRepository;
import pl.coderslab.demo.repository.SetingsRepository;
import pl.coderslab.demo.service.PlayerService;

import javax.validation.Valid;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    ServerRepository serverRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    SetingsRepository setingsRepository;
    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/servers", method = RequestMethod.GET)
    public String serversGet(Model model){
        model.addAttribute("servers", serverRepository.findAll());
        return "servers";
    }
    @RequestMapping("/del/{id}")
    public String dellServer(@PathVariable long id) {
        Server one = serverRepository.findById(id);
        serverRepository.delete(one);
        return "redirect:/user/servers";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPlayer(Model model){
        model.addAttribute("player", new Player());
             return "search";
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPlayer(@Valid SearchDto dto, BindingResult result, Model model)
            throws RegisterFailedException {
        String name = dto.getName();
        List<Player> list = playerRepository.findByFirstnameInclude(name);
        model.addAttribute("result", list);
        return "resultsearch";
    }

    @RequestMapping(value = "/ban/{id}")
    public String ban(@PathVariable long id){
        Player player = playerRepository.findById(id);
        //warunek if jak jest juz ban to usuwa ban
        player.setBanned(true);
        playerRepository.save(player);
        return "redirect:/user/banlist";
    }

    @RequestMapping(value = "/banlist", method = RequestMethod.GET)
    public String banlist(Model model) {
        model.addAttribute("ban", playerRepository.findAllByBannedIsTrue());
        return "banlist";

    }
    @RequestMapping("/delbanlist/{id}")
    public String delbanlist(@PathVariable long id) {
        Player one = playerRepository.findById(id);
        one.setBanned(false);
        playerRepository.save(one);
        return "redirect:/user/banlist";
    }
    @RequestMapping("savebanlist")
    public String savebanlist(){

        List<Player> banlist =  playerRepository.findAllByBannedIsTrue();
        try {
            FileWriter file = new FileWriter("banlistTest.txt", false);
            for (Player s: banlist) {
                file.append(s.getGuid()+"\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error pliku");
        }
        try {
            File file = new File("banlistTest.txt");
            FTPClient ftpClient = FtpClient.open("11.22.33.444",21,"User","Password");
            InputStream input = new FileInputStream(file);
            ftpClient.storeFile("/Binaries/Win32/pb/banlistTest.txt",input);
            FtpClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return"redirect:/";
    }

    @RequestMapping(value = "/seting", method = RequestMethod.GET)
    public String setingAdd(Model model){
        model.addAttribute("seting", new Setings());
        return "seting";
    }
    @RequestMapping(value = "/seting", method = RequestMethod.POST)
    public String setingAdd( @Valid Setings set, BindingResult result, Model model){
        set.setSlected(false);
        setingsRepository.save(set);
        return "/home";
    }
    @RequestMapping(value = "/allsetings", method = RequestMethod.GET)
    public String allSetings(Model model) {
        model.addAttribute("set", setingsRepository.findAll());
        return "allsetings";

    }
    @RequestMapping("/set/{id}")
    public String changeSettings(@PathVariable long id) {
        Setings one = setingsRepository.findById(id);
        if(one.isSlected()){
            one.setSlected(false);
        }else if(!one.isSlected()){
            one.setSlected(true);
        }
        setingsRepository.save(one);
        return "redirect:/user/allsetings";
    }

    @RequestMapping("savesetings")
    public String savesetings(){

      List<Setings> set =  setingsRepository.findAll();
        try {
            FileWriter file = new FileWriter("AAGame.ini", false);
        for (Setings s: set) {
            file.append(s.getDescriotion().toString()+"="+s.isSlected()+"\n");
            System.out.println(file.toString());
        }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error pliku");
        }
        try {
            File file = new File("AAGame.ini");
            FTPClient ftpClient = FtpClient.open("11.22.33.444",21,"User","Password");


            InputStream input = new FileInputStream(file);

            ftpClient.storeFile("/AAGame/Config/g4g/AAGameTest.ini",input);
            FtpClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return"redirect:/";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(){
        //playerService.readAndSave();

        System.out.println("Upload");
        return "home";
    }
}
