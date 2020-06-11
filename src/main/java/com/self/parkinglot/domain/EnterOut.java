package com.self.parkinglot.domain;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

public class EnterOut {
    int CarNumber;
    private Timestamp inTime;
    private Timestamp OutTime;

    @Override
    public String toString() {
        return "EnterOut{" +
                "CarNumber=" + CarNumber +
                ", inTime=" + inTime +
                ", OutTime=" + OutTime +
                ", cost=" + cost +
                '}';
    }

    double cost;

    public int getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(int carNumber) {
        CarNumber = carNumber;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return OutTime;
    }

    public void setOutTime(Timestamp outTime) {
        OutTime = outTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
