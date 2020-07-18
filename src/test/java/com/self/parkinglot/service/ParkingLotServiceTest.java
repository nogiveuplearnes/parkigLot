package com.self.parkinglot.service;


import com.self.parkinglot.dao.ParkingRepo;
import com.self.parkinglot.domain.EnterIn;
import com.self.parkinglot.domain.EnterOut;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)*/
@RunWith(SpringRunner.class)
@SpringBootTest
class ParkingLotServiceTest {


    @MockBean
    private ParkingRepo parkingRepo;


    @SpyBean
    private ParkingLotService parkingLotService;

    @Test()
    public void  test_CalculateCost()
    {
        List<EnterIn> eiList=new ArrayList<>();
        com.self.parkinglot.domain.EnterIn ei=new EnterIn();
        ei.setCarNumber(12);
        ei.setId(766L);
        ei.setInTime(new Timestamp(System.currentTimeMillis()));
        eiList.add(ei);
        Mockito.when(parkingRepo.find(Mockito.anyInt())).thenReturn( eiList);
        EnterOut eo=parkingLotService.calculateCost(12);
        Assert.notNull(eo);
    }


}