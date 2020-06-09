package com.self.parkinglot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface ParkingRepo extends JpaRepository<EnterIn,Long>{

         List<EnterIn> findBycarNumber(int carNumber);

}
