import java.util.Set;

public class Room extends Location {
	
	private int temp;

	public Room(String name, String desc, String longDesc, Item item) {
		super(name, desc, longDesc, item);
	}

	public void allowedPath(Location location) {
		Set<String> directions = map.keySet();
		System.out.println(directions);;
	}
	@Override
	public String describeYourself(){
		if (getEntry()) {
			return getDesc();
		}
		
		return getLongDesc();
		}
}
