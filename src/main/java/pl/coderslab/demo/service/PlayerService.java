package pl.coderslab.demo.service;

import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.Player;

import java.util.List;

@Service
public interface PlayerService {

    Player readAndSave();
    List<Player> findPlayersByName(String name);
    Player banPlayer(long id);
    List<Player> playerBanList();
    Player delBanPlayer(long id);
    Player saveBanList();
}
