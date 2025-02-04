import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Player player;
	private Scanner keyboard = new Scanner(System.in);;
	private ArrayList<Location> locations = new ArrayList<>();

	Location path;
	String command;

	public Game() {

		
		Location entre = new Location("Entre", "wilkammen");
		Location stora = new Location("Stora", "Nu dansar du loss på Stora!");
		Location garderob = new Location("Garderob", "Du letar nu efter kvarglömda jackor i gardden");
		Location baljan = new Location("Baljan", "Välkommen, sugen på kaffe?");
		Location hem = new Location("Hem", "Är du trött");
		
		
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

		baljan.connect("west", entre);

		garderob.connect("south", entre);

	}

	public void run() {

		Player player = new Player(locations.get(1), command);

		System.out.println("Välkommen in i Kårallen!");
		player.inputName(keyboard);
		System.out.println("Hej " + player.getName()
				+ ". Klockan är 23:00. Du har en oöppnad dosa (20 snus) med dig. De är beräknade att räcka precis till klockan 03:00.");
		System.out.println(
				"Ditt mål är att hitta hemsläp. För att öka din sannolikhet att lyckas ska du klara uppdrag på olika ställen i lokalen.");
		System.out.println("Förflytta dig genom att ange ett väderstreck nedan. Ange 'hjälp' för att få hjälp.");

		System.out.println("Du befinner dig just nu i " + player.getPos().getName() + ".");

		while (true) {

			System.out.println(player.getPos().describeYourself());
			System.out.println("Vad vill du göra?");
			String command = keyboard.nextLine();
			Location moveTo = player.getPos().getNB(command);

			if (moveTo != null) {
				player.setPos(moveTo);
				System.out.println(player.getPos().getName());

			}
		}
	}
}