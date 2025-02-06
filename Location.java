
import java.nio.file.Paths;
import java.util.Set;
import java.util.HashMap;

public class Location {

	private String name;
	private String desc;
	private String longDesc;
	public HashMap<String, Location> map = new HashMap<>();
	private boolean entry = false;
	private Item item;

	public Location(String name, String desc, String longDesc, Item item) {
		this.name = name;
		this.desc = desc;
		this.longDesc = longDesc;
		this.item = item;
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

	public String getItemName() {
		return item.getItem();
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem() {
		this.item = null;
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
			return "Välkommen tillbaka till " + this.name + "! " + desc + " Här kan du gå riktiningarna:";
		} else {
			this.entry = true;
			if (getItem() != null) {
				return "Välkommen till " + this.name + "! " + desc + " Här finns föremålet " + getItemName()
						+ ", här kan du gå riktiningarna:";
			} else {
				return "Välkommen till " + this.name + "! " + desc + " Här kan du gå riktiningarna:";
			}
		}
	}

	void allowedPath(Location location) {

	}
}
