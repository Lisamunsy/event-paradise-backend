package co.simplon.eventparadise.dtos;

public class LocationCreateDto {
    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "{name=" + name + "}";
    }
}
