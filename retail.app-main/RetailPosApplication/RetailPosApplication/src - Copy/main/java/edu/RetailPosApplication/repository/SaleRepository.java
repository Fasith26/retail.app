package edu.RetailPosApplication.repository;
import edu.RetailPosApplication.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}