package com.springboot.restapi.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.restapi.onetomany.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long>{

}
