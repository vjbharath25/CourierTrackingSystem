package com.courier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "parcels")
public class Parcel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int parcelId;

@Column(nullable = false)
private String senderName;

@Column(nullable = false)
private String receiverName;

private String senderAddress;
private String receiverAddress;
private String receiverPhone;
private String status;
private LocalDate bookingDate;

// Default constructor
public Parcel() {
}

// Parameterized constructor
public Parcel(String senderName, String receiverName,
              String senderAddress, String receiverAddress,
              String receiverPhone, String status,
              LocalDate bookingDate) {
    this.senderName = senderName;
    this.receiverName = receiverName;
    this.senderAddress = senderAddress;
    this.receiverAddress = receiverAddress;
    this.receiverPhone = receiverPhone;
    this.status = status;
    this.bookingDate = bookingDate;
}

public int getParcelId() {
    return parcelId;
}

public void setParcelId(int parcelId) {
    this.parcelId = parcelId;
}

public String getSenderName() {
    return senderName;
}

public void setSenderName(String senderName) {
    this.senderName = senderName;
}

public String getReceiverName() {
    return receiverName;
}

public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
}

public String getSenderAddress() {
    return senderAddress;
}

public void setSenderAddress(String senderAddress) {
    this.senderAddress = senderAddress;
}

public String getReceiverAddress() {
    return receiverAddress;
}

public void setReceiverAddress(String receiverAddress) {
    this.receiverAddress = receiverAddress;
}

public String getReceiverPhone() {
    return receiverPhone;
}

public void setReceiverPhone(String receiverPhone) {
    this.receiverPhone = receiverPhone;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public LocalDate getBookingDate() {
    return bookingDate;
}

public void setBookingDate(LocalDate bookingDate) {
    this.bookingDate = bookingDate;
}
}
