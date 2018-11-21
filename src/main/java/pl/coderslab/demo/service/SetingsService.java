package pl.coderslab.demo.service;

import pl.coderslab.demo.domain.Setings;

import java.util.List;

public interface SetingsService {

    Setings seve(Setings seting);
    List<Setings> allSetingsList();
    Setings changeSeting(long id);
    Setings saveAllSetings();

}
