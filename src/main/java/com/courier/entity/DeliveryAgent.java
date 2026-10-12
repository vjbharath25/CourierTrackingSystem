package com.courier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_agents")
public class DeliveryAgent {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int agentId;

@Column(nullable = false)
private String agentName;

private String phone;
private String email;
private String vehicleNumber;
private String availability;

public DeliveryAgent() {
}

public DeliveryAgent(String agentName, String phone,
                     String email, String vehicleNumber,
                     String availability) {
    this.agentName = agentName;
    this.phone = phone;
    this.email = email;
    this.vehicleNumber = vehicleNumber;
    this.availability = availability;
}

public int getAgentId() {
    return agentId;
}

public void setAgentId(int agentId) {
    this.agentId = agentId;
}

public String getAgentName() {
    return agentName;
}

public void setAgentName(String agentName) {
    this.agentName = agentName;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getVehicleNumber() {
    return vehicleNumber;
}

public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
}

public String getAvailability() {
    return availability;
}

public void setAvailability(String availability) {
    this.availability = availability;
}


}
