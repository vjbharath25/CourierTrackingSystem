package com.courier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "branches")
public class Branch {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int branchId;

@Column(nullable = false)
private String branchName;

private String location;
private String phone;

public Branch() {
}

public Branch(String branchName, String location, String phone) {
    this.branchName = branchName;
    this.location = location;
    this.phone = phone;
}

public int getBranchId() {
    return branchId;
}

public void setBranchId(int branchId) {
    this.branchId = branchId;
}

public String getBranchName() {
    return branchName;
}

public void setBranchName(String branchName) {
    this.branchName = branchName;
}

public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}
}
