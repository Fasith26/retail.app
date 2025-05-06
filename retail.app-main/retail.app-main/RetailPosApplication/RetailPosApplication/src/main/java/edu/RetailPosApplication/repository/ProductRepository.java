package edu.RetailPosApplication.repository;
import edu.RetailPosApplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}