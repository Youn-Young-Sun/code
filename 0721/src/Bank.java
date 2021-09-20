
public class Bank {
	private String accountNumber,name;
	private int amount;
	
	public Bank() {};
	public Bank(String accountNumber, String name, int price) {
		this.accountNumber=accountNumber;
		this.name=name;
		this.amount=price;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		if(amount<0) System.out.println("잘못된 금액입니다.");
		else this.amount =amount;
	}
	@Override
	public String toString() {
		return name + "\t|  " + accountNumber +"\t|  " + amount +"\t|";
	}
	
}
