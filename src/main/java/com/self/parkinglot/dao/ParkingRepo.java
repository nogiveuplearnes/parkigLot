package com.self.parkinglot.dao;

import com.self.parkinglot.domain.EnterIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParkingRepo extends JpaRepository<EnterIn, Long> {
   @Query("select e from EnterIn e where e.carNumber=:carNumber order by e.inTime desc")
    List<EnterIn>  find(@Param("carNumber") int carNumber);




}
