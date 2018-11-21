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

    private String name;
    private String guid;
    private String ip;
    private boolean banned;



}
