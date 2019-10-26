package net.easy.kars.hire.repository;

import net.easy.kars.hire.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Long>{
}
