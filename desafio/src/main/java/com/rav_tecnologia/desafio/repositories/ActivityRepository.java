package com.rav_tecnologia.desafio.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rav_tecnologia.desafio.models.Activity;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{
	
}