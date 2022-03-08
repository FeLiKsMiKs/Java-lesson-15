package ua.lviv.lgs;

import java.util.Scanner;

public class Menu {
	static void menu() {
		System.out.println("Enter 1 to add member");
		System.out.println("Enter 2 to add animal to member");
		System.out.println("Enter 3 to remove animal from member");
		System.out.println("Enter 4 remove member");
		System.out.println("Enter 5 to remove animal from members");
		System.out.println("Enter 6 to see all zooclub");
		System.out.println("Enter 7 to exit");
	}
public static void main(String[] args) {
	Zooclub map = new Zooclub();
	Scanner sc = new Scanner(System.in);
	while(true) {
		menu();
	switch (sc.nextInt()) {
	case 1: {
		
		map.addMember();
		break;
	}
case 2: {
		
	map.addAnimal();
	break;
	}
case 3: {
	
	map.removeAnimal();
	break;
}
case 4: {
	
	map.removeMember();
	break;
}
case 5: {
	
	map.removeAnimalFromAllMembers();
	break;
}
case 6: {
	
	map.viewAllClub();
	break;
}
case 7: {
	
	System.exit(7);
	break;
}

	default:
		System.out.println("Error");
	}
}
}
}
