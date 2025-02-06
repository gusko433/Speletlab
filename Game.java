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

		Item spade = new Item(2.0, "spade", 2, "Med mig kan du gräva hål i marken");
		Item slaif = new Item(0.001, "slaijf", 800, "Motverkar trötthet");

		Location stora = new Room("Stora", " Nu dansar du loss på Stora!", "Lång beskrivning stora.", spade);
		Location garderob = new Room("Garderob", "Du letar nu efter kvarglömda jackor i gardden.",
				"Lång beskrivning garderob.", spade);
		Location baljan = new Room("Baljan", "Sugen på kaffe?", "Lång beskrivning baljan.", null);
		Location hem = new Room("Hem", "Ska du gå hem?", "Lång beskrivning hem.", null);
		Location entre = new Room("Entre", "Du kom in!", "Lång beskrivning entre.", null);
		Location amfi = new OpenAreas("Amfi", "Ta en cigg.", "Ta en rbv.", null);
		Location havet = new OpenAreas("Blå havet", "Här är det stort och platt.", "Lång beskrivning havet.", null);
		Location logen = new Room("Linda Bengtzings loge", "Här har du upplevt allt!", "Här kan du uppleva allt!",
				slaif);
		Location gasquen = new Room("Gasquen", "Här finns en bar", "Här kan du äta mat, dricka öl och mingla!", null);

		locations.add(entre);
		locations.add(stora);
		locations.add(garderob);
		locations.add(baljan);
		locations.add(hem);
		locations.add(amfi);
		locations.add(havet);
		locations.add(logen);
		locations.add(gasquen);

		entre.connect("syd", stora);
		entre.connect("öst", garderob);
		entre.connect("väst", hem);
		entre.connect("ner", baljan);

		stora.connect("norr", entre);
		stora.connect("väst", amfi);

		baljan.connect("syd", gasquen);
		baljan.connect("upp", entre);

		gasquen.connect("norr", baljan);
		gasquen.connect("öst", logen);

		logen.connect("väst", gasquen);

		garderob.connect("väst", entre);

		hem.connect("öst", entre);
		hem.connect("väst", havet);

		amfi.connect("öst", stora);
		amfi.connect("väst", havet);

		havet.connect("öst", amfi);

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