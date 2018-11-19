package pl.coderslab.demo.service;


import pl.coderslab.demo.domain.Role;

public interface RoleService {
    Role findByName(String name);
    Role save(Role role);
}
