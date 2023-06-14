package tn.esprit.seancespring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CentreCamping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String adresse;

    private String description;

    private Long capacite_acc;

    @OneToMany(mappedBy = "centreCamping",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    //@JsonIgnore
    private List<Activite> activites;

}