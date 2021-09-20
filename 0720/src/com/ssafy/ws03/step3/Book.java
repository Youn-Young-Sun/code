package com.ssafy.ws03.step3;

import java.util.Scanner;

public class Book {
	String isbn, title, author,publisher,desc;
	int price;
	
	public Book() {};
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn=isbn;
		this.author=author;
		this.desc=desc;
		this.price=price;
		this.publisher=publisher;
		this.title=title;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) { 
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return  isbn +"| "+title+"| "+author+"| "+publisher+"| "+price+"| "+desc;
	}
	
}
