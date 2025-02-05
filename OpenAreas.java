import java.util.Set;

public class OpenAreas extends Location {
	
	
	private static String weather = "regn";

	public OpenAreas(String name, String desc, String longDesc) {
		super(name, desc, longDesc);
	}
	
	public void allowedPath(Location location) {
		Set<String> directions = map.keySet();
		System.out.println(directions);;
	}
	
	@Override
	public String describeYourself(){
		if (getEntry()) {
			return getDesc() + " Just nu är det " + weather + " på denna platsen";
		}
		return getLongDesc() + " Just nu är det " + weather + " på denna platsen";
		}
	
	
	
	

}
