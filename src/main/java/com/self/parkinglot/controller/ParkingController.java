package com.self.parkinglot.controller;


import com.self.parkinglot.domain.EnterIn;
import com.self.parkinglot.domain.EnterOut;
import com.self.parkinglot.dao.ParkingRepo;
import com.self.parkinglot.service.ParkingLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {

    private static Logger logger= LoggerFactory.getLogger(ParkingController.class);
    @Autowired
    ParkingRepo repo;

    @Autowired
    ParkingLotService service;

    @RequestMapping("/parking/{carNumber}")
    public EnterOut getCost(@PathVariable("carNumber") int carNumber) {
        return service.calculateCost(carNumber);
    }


    @PostMapping("/parking")
    @ResponseBody
    public EnterIn saveParking(EnterIn eIn) {
        logger.info("Entered parking controller");
        repo.save(eIn);
        return eIn;
    }
}
