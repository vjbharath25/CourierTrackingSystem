package com.courier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tracking_history")
public class TrackingHistory {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int trackingId;

@Column(nullable = false)
private int parcelId;

private String status;

private String location;

private LocalDateTime updateTime;

private String remarks;

public TrackingHistory() {
}

public TrackingHistory(int parcelId, String status,
                       String location, LocalDateTime updateTime,
                       String remarks) {
    this.parcelId = parcelId;
    this.status = status;
    this.location = location;
    this.updateTime = updateTime;
    this.remarks = remarks;
}

public int getTrackingId() {
    return trackingId;
}

public void setTrackingId(int trackingId) {
    this.trackingId = trackingId;
}

public int getParcelId() {
    return parcelId;
}

public void setParcelId(int parcelId) {
    this.parcelId = parcelId;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}

public LocalDateTime getUpdateTime() {
    return updateTime;
}

public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
}

public String getRemarks() {
    return remarks;
}

public void setRemarks(String remarks) {
    this.remarks = remarks;
}

}
