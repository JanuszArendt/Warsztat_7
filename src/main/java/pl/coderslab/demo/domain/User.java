package pl.coderslab.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor //tworzy bezargumentowy konstruktor
@AllArgsConstructor //tworzy konstruktor ze wszystkimi argumentami (oprocz id)
@ToString //tworzy metode to String
public class User extends BaseEntity{

    private String name;
    private String username;
    private String password;
    private int enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    private Set<Role> roles;

 


}
