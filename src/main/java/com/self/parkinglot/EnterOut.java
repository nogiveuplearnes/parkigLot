package com.self.parkinglot;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

public class EnterOut {
    int CarNumber;
    private Date inTime;
    private Date OutTime;

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

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return OutTime;
    }

    public void setOutTime(Date outTime) {
        OutTime = outTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
