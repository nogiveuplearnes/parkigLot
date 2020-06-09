package com.self.parkinglot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ParkingController {
    @Autowired
    ParkingRepo repo;


:wq:wq
qq:wq








    :wq


:q!






AAqqq
A

    @RequestMapping("/parking/{carNumber}")
    public List<EnterOut> getCost(@PathVariable("carNumber") int carNumber){
        List<EnterIn> listIn= repo.findBycarNumber(carNumber);
        List<EnterOut> listOut=new ArrayList<EnterOut>();
        EnterOut eOut=new EnterOut();
        for(EnterIn eIn:listIn){
           eOut.setCarNumber(eIn.getCarNumber());
           eOut.setInTime(eIn.getInTime());
           eOut.setOutTime(new Timestamp(System.currentTimeMillis()));
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(eIn.getInTime().toInstant(), end);
            eOut.setCost(timeElapsed.toMinutes()*20);
            listOut.add(eOut);
        }
        return listOut;
    }


    @PostMapping("/parking")
    @ResponseBody
    public EnterIn saveParking(EnterIn eIn){
        repo.save(eIn);
        return eIn;
    }
}
