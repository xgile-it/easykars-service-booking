package net.easy.kars.hire.controller;


import net.easy.kars.hire.exception.ResourceNotFoundException;
import net.easy.kars.hire.model.Booking;
import net.easy.kars.hire.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v3")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {return bookingRepository.findAll();}

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable(value = "id") Long bookingId)
            throws ResourceNotFoundException {
        Booking booking= bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + bookingId));
        return ResponseEntity.ok().body(booking);
    }

    @PostMapping("/bookings")
    public Booking createBooking(@Valid @RequestBody Booking booking) {return bookingRepository.save(booking);}

    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable(value = "id") Long bookingId,
                                         @Valid @RequestBody Booking bookingDetails) throws ResourceNotFoundException {
        Booking booking  = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + bookingId));

        booking.setPickupDate(bookingDetails.getPickupDate());
        booking.setDropoffDate(bookingDetails.getDropoffDate());
        booking.setFirstName(bookingDetails.getFirstName());
        booking.setLastName(bookingDetails.getLastName());
        booking.setContactNo(bookingDetails.getContactNo());
        booking.setAddress(bookingDetails.getAddress());
        booking.setEmailId(bookingDetails.getEmailId());
        booking.setCardHolder(bookingDetails.getCardHolder());
        booking.setCardNo(bookingDetails.getCardNo());
        booking.setExpiryDate(bookingDetails.getExpiryDate());
        booking.setCvv(bookingDetails.getCvv());

        final Booking updatedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(updatedBooking);
    }

}

