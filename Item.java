
public class Item {

	private double weight;
	private String name;
	private int price;
	private String desc;
	
	public Item(double weight, String name, int price, String desc) {
		this.weight = weight;
		this.name = name;
		this.price = price;
		this.desc = desc;
	}
	
	
	public String printYourself() {
		return this.name + this.desc;
		
	}
	
	public String getItem() {
		return this.name;
	}
	

}
