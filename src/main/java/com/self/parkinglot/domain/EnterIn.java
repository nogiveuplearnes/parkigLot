package com.self.parkinglot.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class EnterIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int carNumber;
    @CreationTimestamp
    private Timestamp inTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    @Override
    public String toString() {
        return "EnterIn{" +
                "carNumber=" + carNumber +
                ", inTime=" + inTime +
                '}';
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }
}
