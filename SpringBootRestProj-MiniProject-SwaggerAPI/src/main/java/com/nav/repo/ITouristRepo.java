package com.nav.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nav.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer>{

	@Query("from Tourist where name=:name")
	List<Tourist> getTouristByName(String name);

}
