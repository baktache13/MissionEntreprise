package tn.esprit.seancespring.entities;

import javax.persistence.*;

@Entity
@Table(name = "Role_camp")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROLE")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="ROLE_NAME",length = 20)
    private ERole name;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}