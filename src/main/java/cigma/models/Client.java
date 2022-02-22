package cigma.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;

    @OneToMany(fetch=FetchType.EAGER,mappedBy = "client",cascade = CascadeType.PERSIST)
    private List<Address> addresses;

    public Client(String name) {
        this.name = name;
    }

    public Client() {
    }
}
