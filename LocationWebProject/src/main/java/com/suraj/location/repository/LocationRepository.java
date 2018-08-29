package com.suraj.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.suraj.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	@Query(value = "SELECT type, COUNT(type) FROM location group by type", nativeQuery = true)
	public List<Object[]> findTypeAndTypeCount();

}
