package edu.RetailPosApplication.repository;
import edu.RetailPosApplication.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
