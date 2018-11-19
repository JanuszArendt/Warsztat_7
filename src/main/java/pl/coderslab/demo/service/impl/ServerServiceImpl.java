package pl.coderslab.demo.service.impl;

import com.sun.deploy.association.RegisterFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.Server;
import pl.coderslab.demo.domain.dto.ServerDto;
import pl.coderslab.demo.repository.ServerRepository;
import pl.coderslab.demo.service.ServerService;
@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    ServerRepository serverRepository;




 @Override
    public Server registerServer(ServerDto dto) throws RegisterFailedException {
        if (dto.getName().isEmpty()){
            throw new RegisterFailedException("Brak nazwy - wpisz nazwę");
        }
        Server server = new Server();
        server.setName(dto.getName());

        return serverRepository.save(server);
    }



}
