package co.simplon.eventparadise.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

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
import co.simplon.eventparadise.dtos.EventCreateDto;
import co.simplon.eventparadise.dtos.EventView;
import co.simplon.eventparadise.entities.Event;
import co.simplon.eventparadise.entities.Location;
import co.simplon.eventparadise.entities.Theme;

@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @Valid @RequestBody EventCreateDto inputs) {
	Event event = new Event();
	event.setName(inputs.getName());
	event.setDate(inputs.getDate());
	Long locationId = inputs.getLocation();
	Location selectedLocation = Database
		.findOneLocation(locationId);
	event.setLocation(selectedLocation);
	Long themeId = inputs.getTheme();
	Theme selectedTheme = Database
		.findOneTheme(themeId);
	event.setTheme(selectedTheme);
	event.setRate(inputs.getRate());
	event.setDescription(inputs.getDescription());
	Database.saveEvent(event);
    }

    @GetMapping
    public Collection<EventView> getAll() {
	Collection<Event> events = Database.findAllEvents();
	Collection<EventView> views = new ArrayList<>();
	for (Event event : events) {
	    EventView view = new EventView();
	    view.setId(event.getId());
	    view.setName(event.getName());
	    view.setDate(event.getDate());
	    view.setLocation(event.getLocation());
	    view.setTheme(event.getTheme());
	    view.setRate(event.getRate());
	    view.setDescription(event.getDescription());
	    views.add(view);
	}
	return views;
    }

    public EventView getOne(@PathVariable("id") Long id) {
	Event event = Database.findOneEvent(id);
	EventView view = new EventView();
	view.setId(event.getId());
	view.setName(event.getName());
	view.setDate(event.getDate());
	view.setLocation(event.getLocation());
	view.setTheme(event.getTheme());
	view.setRate(event.getRate());
	view.setDescription(event.getDescription());
	return view;
    }
}
