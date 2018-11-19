package pl.coderslab.demo.service;

import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.Player;
@Service
public interface PlayerService {

    Player readAndSave();

}
