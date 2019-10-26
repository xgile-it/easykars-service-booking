package net.easy.kars.hire.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name ="bookings")
public class Booking {
    private long id;
    private String pickupDate;
    private String dropoffDate;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String address;
    private String emailId;
    private String cardHolder;
    private String cardNo;
    private String expiryDate;
    private int cvv;

    public Booking(){ }

    public Booking(String pickupDate, String dropoffDate, String firstName, String lastName, String contactNo,String address, String emailId, String cardHolder, String cardNo,String expiryDate, int cvv){
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.address = address;
        this.emailId = emailId;
        this.cardHolder = cardHolder;
        this.cardNo = cardNo;
        this.expiryDate = expiryDate;
        this.cvv = cvv;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    @Column(name ="pickupDate", nullable = false)
    public String getPickupDate() {return  pickupDate;}
    public void setPickupDate(String pickupDate) {this.pickupDate = pickupDate;}

    @Column(name ="dropoffDate", nullable = false)
    public String getDropoffDate() {return  dropoffDate;}
    public void setDropoffDate(String dropoffDate) {this.dropoffDate = dropoffDate;}

    @Column(name ="firstName", nullable = false)
    public String getFirstName() {return  firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    @Column(name ="lastName", nullable = false)
    public String getLastName() {return  lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    @Column(name ="contactNo", nullable = false)
    public String getContactNo() {return  contactNo;}
    public void setContactNo(String contactNo) {this.contactNo = contactNo;}

    @Column(name ="address", nullable = false)
    public String getAddress() {return  address;}
    public void setAddress(String address) {this.address = address;}

    @Column(name ="emailId", nullable = false)
    public String getEmailId() {return  emailId;}
    public void setEmailId(String emailId) {this.emailId = emailId;}

    @Column(name ="cardHolder", nullable = false)
    public String getCardHolder() {return  cardHolder;}
    public void setCardHolder(String cardHolder) {this.cardHolder = cardHolder;}

    @Column(name ="cardNo", nullable = false)
    public String getCardNo() {return  cardNo;}
    public void setCardNo(String cardNo) {this.cardNo = cardNo;}

    @Column(name ="expiryDate", nullable = false)
    public String getExpiryDate() {return  expiryDate;}
    public void setExpiryDate(String expiryDate) {this.expiryDate = expiryDate;}

    @Column(name ="cvv", nullable = false)
    public int getCvv() {return  cvv;}
    public void setCvv(int cvv) {this.cvv = cvv;}

    @Override
    public String toString(){
        return "Booking [id=" + id + ",pickupDate=" + pickupDate + ",dropoffDate=" + dropoffDate + ",firstName=" + firstName + ", lastName=" + lastName + ",contactNo=" + contactNo + ",address=" + address + ",emailId=" + emailId + ", cardHolder=" + cardHolder + ",cardNo=" + cardNo + ",expiryDate=" + expiryDate + ",cvv=" + cvv + "]";

    }

}
