package net.easy.kars.hire.controller;


import net.easy.kars.hire.exception.ResourceNotFoundException;
import net.easy.kars.hire.model.Car;
import net.easy.kars.hire.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v3")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long carId)
            throws ResourceNotFoundException {
        Car car= carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));
        return ResponseEntity.ok().body(car);
    }

    @PostMapping("/cars")
    public Car createCar(@Valid @RequestBody Car car) {return carRepository.save(car);}

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable(value = "id") Long carId,
           @Valid @RequestBody Car carDetails) throws ResourceNotFoundException {
        Car car  = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));

        car.setCarType(carDetails.getCarType());
        car.setBookingPrice(carDetails.getBookingPrice());
        car.setAvailability(carDetails.getAvailability());
        final Car updatedCar = carRepository.save(car);
        return ResponseEntity.ok(updatedCar);
    }

}
