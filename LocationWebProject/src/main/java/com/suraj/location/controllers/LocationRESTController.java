package com.suraj.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.location.entities.Location;
import com.suraj.location.repository.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	// Invoke Repository since we want to JUST perform CRUD Operations
	@Autowired
	private LocationRepository locationRepository;

	// If we want to have business logic present here, we will Invoke the Service
	// Class here

	@GetMapping
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}

	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}

	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationRepository.deleteById(id);
	}

	@GetMapping("/{id}")
	public Location getLocationById(@PathVariable("id") int id) {
		return locationRepository.findById(id).get();
	}

}
