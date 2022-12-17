package co.simplon.eventparadise.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import co.simplon.eventparadise.entities.Event;
import co.simplon.eventparadise.entities.Location;
import co.simplon.eventparadise.entities.Theme;

public class Database {

    private static Long eventId = 0L;
    private static Long locationId = 0L;
    private static Long themeId = 0L;

    private static final Map<Long, Event> EVENTS = new HashMap<>();
    private static final Map<Long, Location> LOCATIONS = new HashMap<>();
    private static final Map<Long, Theme> THEMES = new HashMap<>();

    static {
	String[] themes = { "Ecologie",
		"Ressources Humaines", "Tech" };
	for (int i = 0; i < themes.length; i++) {
	    Theme theme = new Theme(themes[i]);
	    Database.saveTheme(theme);
	}
	String[] locations = { "Paris", "Rennes",
		"Marseille" };
	for (int i = 0; i < locations.length; i++) {
	    Location location = new Location(locations[i]);
	    Database.saveLocation(location);
	}
    }

    public static void saveEvent(Event event) {
	eventId++;
	event.setId(eventId);
	EVENTS.put(eventId, event);
    }

    public static Collection<Event> findAllEvents() {
	return EVENTS.values();
    }

    public static Event findOneEvent(Long id) {
	return EVENTS.get(id);
    }

    public static void saveLocation(Location location) {
	locationId++;
	location.setId(locationId);
	LOCATIONS.put(locationId, location);
    }

    public static Collection<Location> findAllLocations() {
	return LOCATIONS.values();
    }

    public static Location findOneLocation(Long id) {
	return LOCATIONS.get(id);
    }

    public static void saveTheme(Theme theme) {
	themeId++;
	theme.setId(themeId);
	THEMES.put(themeId, theme);
    }

    public static Collection<Theme> findAllThemes() {
	return THEMES.values();
    }

    public static Theme findOneTheme(Long id) {
	return THEMES.get(id);
    }

}
