package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Zooclub {
	Map<Person, ArrayList<Animal>> map = new HashMap<Person, ArrayList<Animal>>();
public void addMember(){
Scanner sc = new Scanner(System.in);
System.out.println("Member name: ");
String memberName = sc.next();
System.out.println("Member age: ");
int memberAge = sc.nextInt();
Person member = new Person(memberName, memberAge);
map.put(member, new ArrayList<Animal>());
System.out.println(member.toString() + " added");
}

public void addAnimal(){
Scanner sc = new Scanner(System.in);
System.out.println("Member name: ");
String memberName = sc.next();
System.out.println("Member age: ");
int memberAge = sc.nextInt();
boolean Yes = isMemberExist(map, memberName , memberAge);

if(Yes) {
	System.out.println("Animal type: ");
	String type = sc.next();
	System.out.println("Animal name: ");
	String AnimalName = sc.next();
	Animal newAnimal = new Animal(type, AnimalName);
	Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
	while(iterator.hasNext()) {
		Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
		if(nextMember.getKey().getName().equalsIgnoreCase(memberName)&& nextMember.getKey().getAge()==memberAge) {
			ArrayList<Animal> anList = nextMember.getValue();
			anList.add(newAnimal);
			System.out.println("Animal: "+ newAnimal.toString() + "added to member: "+ nextMember.getKey());
			
			
		}
	}
	
}else {
	System.out.println("Error");
}
}

public void removeAnimal(){
Scanner sc = new Scanner(System.in);
System.out.println("Member name: ");
String memberName = sc.next();
System.out.println("Member age: ");
int memberAge = sc.nextInt();
boolean Yes = isMemberExist(map, memberName , memberAge);

if(Yes) {
	System.out.println("Animal type: ");
	String type = sc.next();
	System.out.println("Animal name: ");
	String AnimalName = sc.next();
	boolean Yes2 = isAnimalExist(map, memberName , memberAge, type, AnimalName);
	if(Yes2) {
		Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
			if(nextMember.getKey().getName().equalsIgnoreCase(memberName)&& nextMember.getKey().getAge()==memberAge) {
				ArrayList<Animal> anList = nextMember.getValue();
				Iterator<Animal> iterator2 = anList.iterator();
				while(iterator2.hasNext()) {
					Animal next2 = iterator2.next();
					if (next2.getType().equalsIgnoreCase(type)&& next2.getAnimalName().equalsIgnoreCase(memberName)) {
					iterator2.remove();
					System.out.println("Animal: "+ next2.toString()+"removed from member: "+ nextMember.getKey());
				}
				}
			}
		}
	}else {
		System.out.println("Error");
	}
	
}else {
	System.out.println("Error");
}
}

public void removeMember() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Member name: ");
	String memberName = sc.next();
	System.out.println("Member age: ");
	int memberAge = sc.nextInt();
	boolean Yes = isMemberExist(map, memberName , memberAge);

	if(Yes) {
		Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
			if(nextMember.getKey().getName().equalsIgnoreCase(memberName)&& nextMember.getKey().getAge()==memberAge) {
				iterator.remove();
				System.out.println(nextMember.getKey().toString()+" deleted!");
				
			}
		}
	}else {
		System.out.println("Error");
	}
}

public void removeAnimalFromAllMembers() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Animal type: ");
	String type = sc.next();
	Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
	while(iterator.hasNext()) {
		Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
		ArrayList<Animal> anList = nextMember.getValue();
		Iterator<Animal> iterator2 = anList.iterator();
		while(iterator2.hasNext()) {
			Animal next2 = iterator2.next();
			if (next2.getType().equalsIgnoreCase(type)) {
			iterator2.remove();
			System.out.println("Animal: "+ next2.toString()+"removed from member: "+ nextMember.getKey());
		}
		}
	}
}

public void viewAllClub() {
	Set<Entry<Person, ArrayList<Animal>>> members = map.entrySet();
	for(Entry<Person, ArrayList<Animal>> entry: members) {
		System.out.println("Member: "+ entry.getKey()+"has animal: "+ entry.getValue());
	}
}

static boolean isMemberExist(Map<Person, ArrayList<Animal>>map, String name, int age) {
	boolean flag = false;
	Set<Entry<Person, ArrayList<Animal>>> members = map.entrySet();
	for (Entry<Person, ArrayList<Animal>>entry:members) {
		if (entry.getKey().getName().equalsIgnoreCase(name)&& entry.getKey().getAge()==age) {
			flag = true;
		}
		
	}
	return flag;
}
static boolean isAnimalExist(Map<Person, ArrayList<Animal>>map, String name, int age, String type, String AnimalName) {
	boolean flag = false;
	Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
	while (iterator.hasNext()) {
		Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
		if(nextMember.getKey().getName().equalsIgnoreCase(name)&& nextMember.getKey().getAge()==age) {
			ArrayList<Animal> anList = nextMember.getValue();
			Iterator<Animal> iterator2 = anList.iterator();
			while(iterator2.hasNext()) {
				Animal next2 = iterator2.next();
				if (next2.getType().equalsIgnoreCase(type)&& next2.getAnimalName().equalsIgnoreCase(AnimalName)) {
					flag=true;
				}
			}
		}
		
			}
	return flag;
}
}