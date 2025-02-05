
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;


public class Player {

	private String name;
	private Location position;
	private static int snus = 20;
	public HashMap<String, Location> map = new HashMap<>();

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

	public String doCommand(String command) {
		if (command.equals("öst") || command.equals("väst") || command.equals("norr") || command.equals("syd")) {

			Location moveTo = position.getNB(command);
			
			
			if (moveTo != null) {
				
				this.position = moveTo;
				return moveTo.firstTime();

			} else {
				return "Inget i den riktningen";
			}
		}

		else {
			return "felaktigt commando";
		}

		
	}
	
	
}
