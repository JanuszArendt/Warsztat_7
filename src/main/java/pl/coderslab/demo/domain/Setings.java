package pl.coderslab.demo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Setings extends BaseEntity{

    private String descriotion;
    private boolean slected;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion;
    }

    public boolean isSlected() {
        return slected;
    }

    public void setSlected(boolean slected) {
        this.slected = slected;
    }
}
