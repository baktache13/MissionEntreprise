package tn.esprit.seancespring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_act;

    private String description;

    private String duree;

    private int capaciteMax;

    @ManyToMany(mappedBy = "activites")
    private List<CentreCamping> centreCampings;

}
