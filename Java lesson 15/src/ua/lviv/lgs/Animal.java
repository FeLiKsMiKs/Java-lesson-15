package ua.lviv.lgs;

import java.util.Objects;

public class Animal {
private String type;
private String AnimalName;
public Animal(String type, String animalName) {
	super();
	this.type = type;
	AnimalName = animalName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getAnimalName() {
	return AnimalName;
}
public void setAnimalName(String animalName) {
	AnimalName = animalName;
}
@Override
public String toString() {
	return "Animal [type=" + type + ", AnimalName=" + AnimalName + "]";
}
@Override
public int hashCode() {
	return Objects.hash(AnimalName, type);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Animal other = (Animal) obj;
	return Objects.equals(AnimalName, other.AnimalName) && Objects.equals(type, other.type);
}

}
