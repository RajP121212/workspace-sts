package com.suraj.location.controllers;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.suraj.location.entities.Location;
import com.suraj.location.repository.LocationRepository;
import com.suraj.location.service.LocationServiceImpl;
import com.suraj.location.util.IEmailUtil;
import com.suraj.location.util.IReportUtil;

@Controller
public class LocationController {

	@Autowired
	private LocationServiceImpl locationService;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private IEmailUtil emailUtil;
	
	@Autowired
	private IReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		// simply return the .jsp page which is seen by the end user
		return "createLocation";
	}

	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {

		// will return same .jsp page, but when the response goes back to the UI
		// it will display a success message
		// save the location

		Location locationSaved = locationService.saveLocation(location);
		String message = "Location saved with Id: " + locationSaved.getId();
		modelMap.addAttribute("msg", message);
		
		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {

		List<Location> allLocations = locationService.getAllLocations();
		modelMap.addAttribute("locations", allLocations);
		
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {

		Location locationDeleted = locationService.getLocationById(id);
		locationService.deleteLocation(locationDeleted);

		List<Location> allLocations = locationService.getAllLocations();
		modelMap.addAttribute("locations", allLocations);

		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		
		Location locationUpdated = locationService.getLocationById(id);
		modelMap.addAttribute("locations", locationUpdated);
		
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		
		locationService.upadateLocation(location);
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		
		String path = servletContext.getRealPath("/");
		
		List<Object[]> data = locationRepository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		
		return "report";
	}

}
