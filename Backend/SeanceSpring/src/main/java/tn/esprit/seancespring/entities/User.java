package tn.esprit.seancespring.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long id;

    private String username;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "User_Role",
            joinColumns = @JoinColumn(name = "ID_USER"),
            inverseJoinColumns = @JoinColumn(name = "ID_ROLE"))
    private Set<Role> roles = new HashSet<>();

    @Column(name="NOM")
    private String nom;

    @OneToMany(mappedBy = "user")
    private List<Reclamation> reclamations;

    @Column(name="PRENOM")
    private String prenom;

    public User() {
    }



    public User(String username, String email,
                String password, Set<Role> roles, String nom, String prenom) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
    }



    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
