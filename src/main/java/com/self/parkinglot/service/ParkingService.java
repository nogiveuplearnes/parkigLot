package com.self.parkinglot.service;

import com.self.parkinglot.domain.EnterIn;
import com.self.parkinglot.domain.EnterOut;
import com.self.parkinglot.dao.ParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    @Autowired
    ParkingRepo repo;

    public List<EnterOut> calculateCost(int carNumber) {
        List<EnterIn> listIn = repo.find(carNumber);
        List<EnterOut> listOut = new ArrayList<EnterOut>();
        EnterOut eOut = new EnterOut();
        int i=0;
        for (EnterIn eIn : listIn) {
            if(i==1) break;
            eOut.setCarNumber(eIn.getCarNumber());
            eOut.setInTime(eIn.getInTime());
            eOut.setOutTime(new Timestamp(System.currentTimeMillis()));
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(eIn.getInTime().toInstant(), end);
            eOut.setCost(timeElapsed.toMinutes() * 20);
            listOut.add(eOut);
            i++;
        }
        return listOut;
    }
}
