package tn.esprit.seancespring.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Temporal(TemporalType.DATE)
    private Date birthDate;

}
