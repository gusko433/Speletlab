
import java.nio.file.Paths;
import java.util.Set;
import java.util.HashMap;

public class Location {

	private String name;
	private String desc;
	private String longDesc;
	public HashMap<String, Location> map = new HashMap<>();
	private boolean entry = false;

	public Location(String name, String desc, String longDesc) {
		this.name = name;
		this.desc = desc;
		this.longDesc = longDesc;
	}

	public void connect(String direction, Location path) {
		this.map.put(direction, path);

	}

	public String getLocation() {
		return name;

	}

	public String getName() {
		return name;
	}

	public String describeYourself() {
		return desc;

	}

	public Location getNB(String direction) {
		if (map.get(direction) != null) {
			return map.get(direction);
		} else {
			return null;
		}

	}
	
	public void setEntry() {
		this.entry = true;
	}

	public String firstTime() {
		if (entry) {
			return "Välkommen tillbaka till " + this.name + ", här kan du gå riktiningarna:";
		} else {
			this.entry = true;
			return "Välkommen till " + this.name + ", " + this.longDesc + ", här kan du gå riktiningarna:";
		}
	}
	public Set<String> allowedPath(Location location) {
		Set<String> directions = map.keySet();
		return directions;
	}

	
}
