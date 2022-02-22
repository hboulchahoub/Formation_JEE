package cigma.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    public Address(String description) {
        this.description = description;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="FK_CLIENT_ID")
    private Client client;

}
