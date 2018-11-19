package pl.coderslab.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String guid;
    private String ip;
    private boolean banned;
    @ManyToMany(mappedBy = "players")
    private Set<Server> servers;


}
