package com.self.parkinglot;



import com.self.parkinglot.controller.ParkingController;
import com.self.parkinglot.dao.ParkingRepo;
import com.self.parkinglot.domain.EnterOut;
import com.self.parkinglot.service.ParkingLotService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@WebMvcTest(ParkingController.class)
class ParkinglotApplicationTests {



	@MockBean
	private ParkingLotService parkingLotService;

	@MockBean
	private ParkingRepo parkingRepo;

	@Autowired
	private MockMvc mockMvc;

	@SpyBean
	private ParkingController parkingController;




	@Test
	public void test_SaveParking() throws Exception {
		EnterOut eo=new EnterOut();
		eo.setCarNumber(123);
		eo.setCost(20.00);
		eo.setInTime(new Timestamp(System.currentTimeMillis()-10000));
		eo.setInTime(new Timestamp(System.currentTimeMillis()));
		Mockito.when(parkingLotService.calculateCost(Mockito.anyInt())).thenReturn(eo); //stubbing methods;
		ResultMatcher response=MockMvcResultMatchers.xpath("cost").string("20.00");
		mockMvc.perform(MockMvcRequestBuilders.get("/parking/123")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	}

}
