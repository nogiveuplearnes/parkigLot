package com.self.parkinglot;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Entity
public class EnterIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int carNumber;
    @CreationTimestamp
    private Date inTime;

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

    public Date getInTime() {
        return inTime;
    }

    @Override
    public String toString() {
        return "EnterIn{" +
                "carNumber=" + carNumber +
                ", inTime=" + inTime +
                '}';
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
}
