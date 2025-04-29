package edu.RetailPosApplication.repository;
import edu.RetailPosApplication.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sales, Long> {
}