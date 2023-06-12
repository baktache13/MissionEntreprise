package tn.esprit.seancespring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.seancespring.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}