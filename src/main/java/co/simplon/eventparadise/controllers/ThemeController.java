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
import co.simplon.eventparadise.dtos.ThemeCreateDto;
import co.simplon.eventparadise.dtos.ThemeView;
import co.simplon.eventparadise.entities.Theme;

@RestController
@RequestMapping("/themes")
@CrossOrigin
public class ThemeController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody ThemeCreateDto inputs) {
	Theme theme = new Theme(inputs.getName());
	Database.saveTheme(theme);
    }

    @GetMapping
    public Collection<ThemeView> getAll() {

	Collection<Theme> themes = Database.findAllThemes();
	Collection<ThemeView> views = new ArrayList<>();
	for (Theme theme : themes) {
	    ThemeView view = new ThemeView();
	    view.setId(theme.getId());
	    view.setName(theme.getName());
	    views.add(view);
	}
	return views;
    }

    @GetMapping("/{id}")
    public ThemeView getOne(@PathVariable("id") Long id) {
	Theme theme = Database.findOneTheme(id);
	ThemeView view = new ThemeView();
	view.setId(theme.getId());
	view.setName(theme.getName());
	return view;
    }
}
