
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
		return this.name;
	}


	public void setEntry() {
		this.entry = true;
	}
	
	public Boolean getEntry() {
		return this.entry;
	}
	
	public String describeYourself() {
		if (entry) {
			return this.desc;
		}
		return this.longDesc;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getLongDesc() {
		return this.longDesc;
	}

	public Location getNB(String direction) {
		if (map.get(direction) != null) {
			return map.get(direction);
		} else {
			return null;
		}

	}

	public String firstTime() {
		String desc;
		desc = describeYourself();
		
		if (entry) {
			return "Välkommen tillbaka till " + this.name + desc + ", här kan du gå riktiningarna:";
		} else {
			this.entry = true;
			return "Välkommen till " + this.name + ", " + desc + ", här kan du gå riktiningarna:";
		}
	}
	void allowedPath(Location location) {
		
	}
}
