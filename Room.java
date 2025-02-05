import java.util.Set;

public class Room extends Location {
	
	

	public Room(String name, String desc, String longDesc) {
		super(name, desc, longDesc);
	}

	public void allowedPath(Location location) {
		Set<String> directions = map.keySet();
		System.out.println(directions);;
	}
	
	public String describeYourself(){
		if (getEntry()) {
			return getDesc();
		}
		
		return getLongDesc();
		}
}
