package com.suraj.location.service;

import java.util.List;

import com.suraj.location.entities.Location;

public interface ILocationService {

	Location saveLocation(Location location);

	Location upadateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocationById(int id);

	List<Location> getAllLocations();
}
