package pl.coderslab.demo.service;

import com.sun.deploy.association.RegisterFailedException;
import pl.coderslab.demo.domain.User;
import pl.coderslab.demo.domain.dto.RegisterDto;

import java.util.List;

public interface UserService {

    User save(User u);
    User saveAdmin(User u);
    List<User> findAll();
    User findByUsername(String username);
    User registerUser(RegisterDto dto) throws RegisterFailedException;
}
