package pl.coderslab.demo.service;

import com.sun.deploy.association.RegisterFailedException;
import pl.coderslab.demo.domain.Server;
import pl.coderslab.demo.domain.dto.ServerDto;

import java.util.List;

public interface ServerService {

    Server registerServer(ServerDto dto) throws RegisterFailedException;
    List<Server> findAllServers();
    Server findServerById(long id);
    Server deleteServer (long id);
}
