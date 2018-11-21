package pl.coderslab.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Server extends BaseEntity{

    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<User> users;
}
