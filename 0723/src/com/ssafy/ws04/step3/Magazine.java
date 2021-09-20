package com.ssafy.ws04.step3;

public class Magazine extends Book{
	int year;
	int month;
	
	public Magazine() {}
	public Magazine(String isbn, String title, String author, String publisher, String desc,int price, int quantity,
			int year, int month) {
		super(isbn,title,author,publisher,desc,price,quantity);
		this.year = year;
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return super.toString()+", year="+year+", month=" + month +"]";
	}
	
	

}
