package pl.coderslab.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor //tworzy bezargumentowy konstruktor
@AllArgsConstructor //tworzy konstruktor ze wszystkimi argumentami (oprocz id)
@ToString //tworzy metode to String
@Entity
public class Role extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy="roles")
    Set<User> users;


}
