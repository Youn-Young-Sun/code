package Product;

public class Product {
	private int price, amount;
	private String name,num;
	
	public Product() {};
	public Product(String num, int price, int amount, String name) {
		super();
		this.num = num;
		this.price = price;
		this.amount = amount;
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	public String getNum() {
		return num;
	}
	@Override
	public String toString() {
		return "Product [price=" + price + ", amount=" + amount + ", name=" + name + ", num=" + num + "]";
	}
	
	
}
