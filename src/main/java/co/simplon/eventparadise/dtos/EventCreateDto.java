package co.simplon.eventparadise.dtos;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class EventCreateDto {

    @NotEmpty(message = "Champ obligatoire")
    @Size(max = 255, min = 1, message = "Doit compter de 1 à 255 caractères.")
    private String name;

    @FutureOrPresent(message = "La date doit être égale ou supérieure à aujourd'hui")
    @NotNull(message = "Champ obligatoire")
    private LocalDate date;

    @NotNull(message = "Champ obligatoire")
    private Long location;

    @NotNull(message = "Champ obligatoire")
    private Long theme;

    @NotNull(message = "Champ obligatoire")
    @Positive(message = "Le tarif doit être positif")
    private double rate;

    @NotEmpty(message = "Champ obligatoire")
    @Size(max = 1000, min = 1, message = "Doit compter entre entre 1 et 1000 caractères")
    private String description;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;
    }

    public Long getLocation() {
	return location;
    }

    public void setLocation(Long location) {
	this.location = location;
    }

    public Long getTheme() {
	return theme;
    }

    public void setTheme(Long theme) {
	this.theme = theme;
    }

    public double getRate() {
	return rate;
    }

    public void setRate(double rate) {
	this.rate = rate;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return "{name=" + name + ", date=" + date
		+ ", location=" + location + ", theme="
		+ theme + ", rate=" + rate
		+ ", description=" + description + "}";
    }

}