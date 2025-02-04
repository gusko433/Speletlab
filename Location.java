
import java.nio.file.Paths;
import java.util.HashMap;

public class Location {

	private static String name;
	private static String desc;
	private HashMap<String, Location> map = new HashMap<>();

	public Location(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public void connect(String direction, Location path) {
		this.map.put(direction, path);

	}

	public static String getLocation() {
		return name;

	}
	
	public static String getName() {
		return name;
	}
	
	public static String describeYourself() {
		return desc; 

	}
	
	public Location getNB(String direction) {
		if (map.get(direction) != null) {
			return map.get(direction);
		}else {
			return null;
		}
			
	}
	
	

	
}
