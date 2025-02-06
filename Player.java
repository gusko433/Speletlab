
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {

	private String name;
	private Location position;
	private static int energi = 100;
	private static int pengar = 500;
	public HashMap<String, Location> map = new HashMap<>();
	private ArrayList<Item> inventory = new ArrayList<>();

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

	public int getPengar() {
		return this.pengar;
	}
	
	public void setPengar() {
		this.pengar = pengar
	}

	public int getEnergi() {
		return this.energi;
	}

	public void addItem(Item item) {
		inventory.add(item);
	}

	public Location getPos() {
		return position;
	}

	public ArrayList<Item> getInventory() {
		return this.inventory;
	}

	public void setPos(Location newLocation) {
		this.position = newLocation;
	}

	public String itemNames() {
		String allNames = "";
		for (int i = 0; i < inventory.size(); ++i) {
			if (i == 0) {
				allNames = inventory.get(i).getItem();
			} else {
				allNames = allNames + " " + inventory.get(i).getItem();
			}

		}
		return allNames;
	}

	public String doCommand(String command) {
		if (command.equals("öst") || command.equals("väst") || command.equals("norr") || command.equals("syd") || command.equals("ner") || command.equals("ner")) {

			Location moveTo = position.getNB(command);

			if (moveTo != null) {

				this.position = moveTo;
				return moveTo.firstTime();

			} else {
				return "Inget i den riktningen";
			}
		} else if (command.equals("player info")) {
			return "Du har "  + getEnergi() + "% energi" + " och ditt inventory består av följande: " + itemNames();

		} else if (command.equals("help")) {
			return "Du kan använda följande kommandon: player info";
		} else if (command.equals("plocka upp")) {
			String itemName = getPos().getItemName();
			addItem(getPos().getItem());
			getPos().setItem();
			return "Du har plockat upp " + itemName;
		}

		else {
			return "felaktigt commando";
		}

	}

}
