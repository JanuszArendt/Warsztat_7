package pl.coderslab.demo.service.impl;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.FtpClient;
import pl.coderslab.demo.domain.Player;
import pl.coderslab.demo.repository.PlayerRepository;
import pl.coderslab.demo.service.PlayerService;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player readAndSave() {
        File file = new File("00000023.log");
        try {
            FTPClient ftpClient = FtpClient.open("11.22.33.444",21,"User","Password");
            OutputStream output = new FileOutputStream(file);
            ftpClient.retrieveFile("/Binaries/Win32/pb/svlogs/00000023.log",output);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Set<Player> players = new HashSet<>();
        Player player = new Player();
        Pattern ip = Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        Pattern guid = Pattern.compile(" \\d{32}");
        Pattern name = Pattern.compile(" \\S{1,32}$");

            String a="", b="", c="";

        try{
            Scanner scan = new Scanner(file);
            Pattern test = Pattern.compile("^(\\S{11}\\s\\S{8}\\S\\s)(\\S{1,22})"); //  pierwszy wyzaz po dacie i godzinie od 1 do 22 znaków do spacji
            while(scan.hasNext()){
                String line = scan.nextLine();
                Matcher matcher = test.matcher(line);

                while(matcher.find()){
                    List<String> skip = new ArrayList<>();
                    skip.add("New");
                    skip.add("Running");

                    List<String> read = new ArrayList<>();
                    read.add("Player");
                    read.add("Lost");

                    if(!skip.contains(matcher.group(2)) && !read.contains(matcher.group(2))){
                        try {
                            FileWriter fw = new  FileWriter("pominiete.txt", true);
                            fw.append(line + "\n");
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else if(read.contains(matcher.group(2))){
                        try{
                            Matcher getName = name.matcher(line);
                            Matcher getIp = ip.matcher(line);
                            Matcher getGuid = guid.matcher(line);

                            while(getName.find()){
                              // player.setGuid(getGuid.group());
                               a = getName.group();
                            }
                            while (getIp.find()){
                                 b = getIp.group();
                            }
                            while (getGuid.find()){
                                 c = getGuid.group();
                            }
                            if(playerRepository.findTopByGuidAndNameAndIp(c,a,b)==null) {
                                Player player1 = new Player();
                                player1.setName(a);
                                player1.setIp(b);
                                player1.setGuid(c);
                                playerRepository.save(player1);
                            }
                            FileWriter out = new FileWriter("zebrane.txt", true);
                            out.append(line + "\n");
                            //System.out.println(line);
                            out.close();
                        }catch(IOException ex){
                             System.out.println("nie można zapisać danych do pliku");
                        }
                    }
                }
            }

        }catch(FileNotFoundException e){
            System.out.println("brak pliku do odczytu !!");
        }
        return null;
    }

    @Override
    public List<Player> findPlayersByName(String name) {
        List<Player> players = playerRepository.findByFirstnameInclude(name);
        return players;
    }

    @Override
    public Player banPlayer(long id) {
        Player player = playerRepository.findById(id);
        if (!player.isBanned()){
            player.setBanned(true);
            playerRepository.save(player);
        }else {
            System.out.println("player jest już na liście banów");
        }
        return null;
    }

    @Override
    public List<Player> playerBanList() {
        List<Player> banedPlayers = playerRepository.findAllByBannedIsTrue();
        return banedPlayers;
    }

    @Override
    public Player delBanPlayer(long id) {
        Player player = playerRepository.findById(id);
        player.setBanned(false);
        playerRepository.save(player);
        return null;
    }

    @Override
    public Player saveBanList() {
        List<Player> banlist =  playerRepository.findAllByBannedIsTrue();
        try {
            FileWriter file = new FileWriter("banlistTest.txt", false);
            for (Player s: banlist) {
                file.append(s.getGuid()+"\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("błąd zapisu pliku");
        }
        try {
            File file = new File("banlistTest.txt");
            FTPClient ftpClient = FtpClient.open("11.22.33.444",21,"User","Password");
            InputStream input = new FileInputStream(file);
            ftpClient.storeFile("/Binaries/Win32/pb/banlistTest.txt",input);
            FtpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("brak możliwości połączenia ftp");
        }
        return null;
    }
}
