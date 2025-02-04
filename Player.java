
import java.util.Scanner;

public class Player {

	private String name;
	private Location position;
	private static int snus = 20;
	
	public Player(Location position, String name) {
		this.position = position;
	}

	public void inputName(Scanner keyboard) {

		System.out.println("Ange ditt namn nedan för att börja!");
		String name = keyboard.nextLine();
		this.name = name;

	}

	public String getName() {
		return name;

	}
	
	public Location getPos() {
		return position;
	}
	
	public void setPos(Location newLocation) {
		this.position = newLocation;
	}
	
	public void moveTo(Location path) {
			this.position = path;
	}
	
	

}
