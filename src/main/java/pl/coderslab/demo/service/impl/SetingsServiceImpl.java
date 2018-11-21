package pl.coderslab.demo.service.impl;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.FtpClient;
import pl.coderslab.demo.domain.Setings;
import pl.coderslab.demo.repository.SetingsRepository;
import pl.coderslab.demo.service.SetingsService;

import java.io.*;
import java.util.List;

@Service
public class SetingsServiceImpl implements SetingsService {

    @Autowired
    SetingsRepository setingsRepository;

    @Override
    public Setings seve(Setings set) {
        set.setSlected(false);
        setingsRepository.save(set);
        return null;
    }

    @Override
    public List<Setings> allSetingsList() {
        List<Setings> setingsList = setingsRepository.findAll();
        return setingsList;
    }

    @Override
    public Setings changeSeting(long id) {
        Setings one = setingsRepository.findById(id);
        if(one.isSlected()){
            one.setSlected(false);
        }else if(!one.isSlected()){
            one.setSlected(true);
        }
        setingsRepository.save(one);
        return null;
    }

    @Override
    public Setings saveAllSetings() {
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
        return null;
    }
}
