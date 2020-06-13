package com.self.parkinglot.service;

import com.self.parkinglot.dao.ParkingRepo;
import com.self.parkinglot.domain.EnterIn;
import com.self.parkinglot.domain.EnterOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

@Service
public class ParkingLotService {
    @Autowired
    ParkingRepo repo;

    public EnterOut calculateCost(int carNumber) {
        EnterIn eIn = repo.find(carNumber).get(0);
        EnterOut eOut = new EnterOut();
        eOut.setCarNumber(eIn.getCarNumber());
        eOut.setInTime(eIn.getInTime());
        eOut.setOutTime(new Timestamp(System.currentTimeMillis()));
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(eIn.getInTime().toInstant(), end);
        eOut.setCost(timeElapsed.toMinutes() * 20);
        return eOut;
    }
}
