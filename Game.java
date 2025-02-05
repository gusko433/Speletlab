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

		Location stora = new Room("Stora", " Nu dansar du loss på Stora!", "Lång beskrivning stora");
		Location garderob = new Room("Garderob", "Du letar nu efter kvarglömda jackor i gardden", "Lång beskrivning garderob");
		Location baljan = new Room("Baljan", "Välkommen, sugen på kaffe?", "Lång beskrivning baljan");
		Location hem = new Room("Hem", "Är du trött", "Lång beskrivning hem");
		Location entre = new Room("Entre", "wilkammen", "Lång beskrivning entre");
		Location amfi = new OpenAreas("Amfi", "ta en cigg", "Ta en rbv");
		Location havet = new OpenAreas("Blå havet", "Kort beskrivning", "lång beskrivning");

		locations.add(entre);
		locations.add(stora);
		locations.add(garderob);
		locations.add(baljan);
		locations.add(hem);
		locations.add(amfi);
		locations.add(havet);
		
		entre.connect("öst", stora);
		entre.connect("väst", baljan);
		entre.connect("norr", garderob);
		entre.connect("syd", hem);

		stora.connect("väst", entre);
		stora.connect("syd", amfi);
		

		baljan.connect("öst", entre);

		garderob.connect("syd", entre);

		hem.connect("norr", entre);

		amfi.connect("norr", stora);
		amfi.connect("syd", havet);
		
		havet.connect("norr", amfi);
		
		
		
		
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
			
			player.getPos().allowedPath(path);


		}
	}
}