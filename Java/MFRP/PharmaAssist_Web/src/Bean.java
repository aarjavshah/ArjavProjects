

public class Bean {
	
	String batchcode;
	String medicinecode;
	int weight;
	int price;
	char medicinetype;
	String refregeration;
	int shippingcharge;
	String level;
	
	public Bean()
	{
		
	}
	public Bean(String batchcode, String medicinecode, int weight, int price,
			char medicinetype, String refregeration, int shippingcharge,
			String level) {
		super();
		this.batchcode = batchcode;
		this.medicinecode = medicinecode;
		this.weight = weight;
		this.price = price;
		this.medicinetype = medicinetype;
		this.refregeration = refregeration;
		this.shippingcharge = shippingcharge;
		this.level = level;
	}
	public String getBatchcode() {
		return batchcode;
	}
	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}
	public String getMedicinecode() {
		return medicinecode;
	}
	public void setMedicinecode(String medicinecode) {
		this.medicinecode = medicinecode;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getMedicinetype() {
		return medicinetype;
	}
	public void setMedicinetype(char medicinetype) {
		this.medicinetype = medicinetype;
	}
	public String getRefregeration() {
		return refregeration;
	}
	public void setRefregeration(String refregeration) {
		this.refregeration = refregeration;
	}
	public int getShippingcharge() {
		return shippingcharge;
	}
	public void setShippingcharge(int shippingcharge) {
		this.shippingcharge = shippingcharge;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	

}

