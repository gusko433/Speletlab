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

		Location stora = new Location("Stora", "Nu dansar du loss på Stora!", "Lång beskrivning stora");
		Location garderob = new Location("Garderob", "Du letar nu efter kvarglömda jackor i gardden", "Lång beskrivning garderob");
		Location baljan = new Location("Baljan", "Välkommen, sugen på kaffe?", "Lång beskrivning baljan");
		Location hem = new Location("Hem", "Är du trött", "Lång beskrivning hem");
		Location entre = new Location("Entre", "wilkammen", "Lång beskrivning entre");

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
		this.player.getPos().setEntry();
		
		System.out.println("Välkommen in i Kårallen!");
		player.inputName(keyboard);
		System.out.println("Hej " + player.getName()
				+ ". Klockan är 23:00. Du har en oöppnad dosa (20 snus) med dig. De är beräknade att räcka precis till klockan 03:00.");
		System.out.println(
				"Ditt mål är att hitta hemsläp. För att öka din sannolikhet att lyckas ska du klara uppdrag på olika ställen i lokalen.");
		System.out.println("Förflytta dig genom att ange ett väderstreck nedan. Ange 'hjälp' för att få hjälp.");
		System.out.println("Du befinner dig i entren");

		

		while (true) {
			System.out.println("Vad vill du göra?");
			this.command = keyboard.nextLine();
			
			
			
			System.out.println(player.doCommand(command));
			
			System.out.println(player.getPos().allowedPath(player.getPos()));

		}
	}
}