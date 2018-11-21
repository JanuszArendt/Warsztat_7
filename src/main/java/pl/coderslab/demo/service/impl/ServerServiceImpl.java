package pl.coderslab.demo.service.impl;

import com.sun.deploy.association.RegisterFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.demo.domain.Server;
import pl.coderslab.demo.domain.dto.ServerDto;
import pl.coderslab.demo.repository.ServerRepository;
import pl.coderslab.demo.service.ServerService;

import java.util.List;

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
        server.setUsers(dto.getUsers());
        return serverRepository.save(server);
    }

    @Override
    public List<Server> findAllServers() {
        List<Server> servers = serverRepository.findAll();
        return servers;
    }

    @Override
    public Server findServerById(long id) {
        Server server = serverRepository.findById(id);
        return server;
    }

    @Override
    public Server deleteServer(long id) {
        Server server = serverRepository.deleteById(id);
        return null;
    }
}
