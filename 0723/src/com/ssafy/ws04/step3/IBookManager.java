package com.ssafy.ws04.step3;

import java.util.ArrayList;

public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	ArrayList<Book> getList();	
	Book searchByIsbn(String isbn) ;
	ArrayList<Book> searchByTitle(String title);
	ArrayList<Book> getBooks();
	ArrayList<Book> getMagazines();	
	int getTotalPrice();
	double getPriceAvg();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException; 
	void buy(String isbn, int quantity) throws ISBNNotFoundException; 
}
