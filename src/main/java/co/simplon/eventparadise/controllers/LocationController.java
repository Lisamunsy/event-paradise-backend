package co.simplon.eventparadise.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.eventparadise.database.Database;
import co.simplon.eventparadise.dtos.LocationCreateDto;
import co.simplon.eventparadise.dtos.LocationView;
import co.simplon.eventparadise.entities.Location;

@RestController
@RequestMapping("/locations")
@CrossOrigin
public class LocationController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @RequestBody LocationCreateDto inputs) {
	Location location = new Location(inputs.getName());
	Database.saveLocation(location);
    }

    @GetMapping
    public Collection<LocationView> getAll() {
	Collection<Location> locations = Database
		.findAllLocations();
	Collection<LocationView> views = new ArrayList<>();
	for (Location location : locations) {
	    LocationView view = new LocationView();
	    view.setId(location.getId());
	    view.setName(location.getName());
	    views.add(view);
	}
	return views;
    }

    @GetMapping("/{id}")
    public LocationView getOne(
	    @PathVariable("id") Long id) {
	Location location = Database.findOneLocation(id);
	LocationView view = new LocationView();
	view.setId(location.getId());
	view.setName(location.getName());
	return view;
    }

}
