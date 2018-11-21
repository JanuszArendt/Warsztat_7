package pl.coderslab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.demo.domain.Server;

import java.util.List;

public interface ServerRepository  extends JpaRepository<Server, Long> {


    Server findById(long id);
    List<Server> findAll();
    Server deleteById(long id);

}
