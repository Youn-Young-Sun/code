package Product;

public class TV extends Product{
	private int inch;

	public TV(String num, int price, int amount, String name, int inch) {
		super(num, price, amount, name);
		this.inch = inch;
	}
	
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return  super.toString() + "inch=" + inch + "]";
	}
	
	
	
}
