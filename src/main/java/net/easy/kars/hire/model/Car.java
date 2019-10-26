package net.easy.kars.hire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="cars")
public class Car {
    private long id;
    private String carType;
    private long bookingPrice;
    private boolean availability;

    public Car(){

    }

    public Car(String carType, long bookingPrice, boolean availability){
        this.carType = carType;
        this.bookingPrice = bookingPrice;
        this.availability = availability;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    @Column(name ="car_type", nullable = false)
    public String getCarType() {return  carType;}
    public void setCarType(String carType) {this.carType = carType;}

    @Column(name = "bookingPrice", nullable = false)
    public long getBookingPrice() {return bookingPrice;}
    public void setBookingPrice(long bookingPrice) {this.bookingPrice = bookingPrice;}

    @Column(name = "availability", nullable = false )
    public boolean getAvailability() {return availability;}
    public void setAvailability(boolean availability) {this.availability = availability;  }

    @Override
    public String toString(){
        return "Car [id=" + id + ",carType=" + carType + ",bookingPrice=" + bookingPrice + ",availability=" + availability + "]";

    }
}
