package com.self.parkinglot.dao;

import com.self.parkinglot.domain.EnterIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParkingRepo extends JpaRepository<EnterIn, Long> {
    //@Query("select e from EnterIn e where e.carNumber=:carNumber order by inTime LIMIT 1")
    @Query("select e from EnterIn e where e.carNumber=:carNumber order by e.inTime")
    List<EnterIn>  find(@Param("carNumber") int carNumber);

}
