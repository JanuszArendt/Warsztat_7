package pl.coderslab.demo.service;

import com.sun.deploy.association.RegisterFailedException;
import pl.coderslab.demo.domain.Server;
import pl.coderslab.demo.domain.dto.ServerDto;

public interface ServerService {

    Server registerServer(ServerDto dto) throws RegisterFailedException;
}
