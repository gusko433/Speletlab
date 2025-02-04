import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Scanner keyboard = new Scanner(System.in);;
	private ArrayList<Location> locations = new ArrayList<>();
	private Player player;

	Location path;
	String command;

	public Game() {

		Location stora = new Location("Stora", "Nu dansar du loss på Stora!");
		Location garderob = new Location("Garderob", "Du letar nu efter kvarglömda jackor i gardden");
		Location baljan = new Location("Baljan", "Välkommen, sugen på kaffe?");
		Location hem = new Location("Hem", "Är du trött");
		Location entre = new Location("Entre", "wilkammen");

		locations.add(entre);
		locations.add(stora);
		locations.add(garderob);
		locations.add(baljan);
		locations.add(hem);

		entre.connect("east", stora);
		entre.connect("west", baljan);
		entre.connect("north", garderob);
		entre.connect("south", hem);

		stora.connect("west", entre);

		baljan.connect("east", entre);

		garderob.connect("south", entre);

		hem.connect("north", entre);

	}
	
	public Player getPlayer(Player player) {
		return player;
	}

	public void run() {

		this.player = new Player(locations.get(0), command);
		
		System.out.println("Välkommen in i Kårallen!");
		player.inputName(keyboard);
		System.out.println("Hej " + player.getName()
				+ ". Klockan är 23:00. Du har en oöppnad dosa (20 snus) med dig. De är beräknade att räcka precis till klockan 03:00.");
		System.out.println(
				"Ditt mål är att hitta hemsläp. För att öka din sannolikhet att lyckas ska du klara uppdrag på olika ställen i lokalen.");
		System.out.println("Förflytta dig genom att ange ett väderstreck nedan. Ange 'hjälp' för att få hjälp.");

		

		while (true) {
			System.out.println("Du befinner dig just nu i " + player.getPos().getName() + ".");
			System.out.println(player.getPos().describeYourself());
			System.out.println("Vad vill du göra?");
			this.command = keyboard.nextLine();
			
			System.out.println(player.doCommand(command));
			

		}
	}
}