package tn.esprit.seancespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.seancespring.entities.OrderProduct;
import tn.esprit.seancespring.entities.OrderProductKey;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductKey> {
    @Query("SELECT op FROM OrderProduct op WHERE op.id.orderId = :orderId")
    List<OrderProduct> findByOrderId(@Param("orderId") Long orderId);
}
