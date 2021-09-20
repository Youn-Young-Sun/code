package com.ssafy.ws04.step3;

import java.util.ArrayList;


public class BookManagerImpl implements IBookManager{
	
	private static BookManagerImpl instance = new BookManagerImpl();
	public static BookManagerImpl getInstance() {
		return instance;
	}

	private ArrayList<Book> bookList;
	private BookManagerImpl() {
		super();
		bookList=new ArrayList<>();
	}
	
	@Override
	public void add(Book book) {
		bookList.add(book);
		
	}
	@Override
	public void remove(String isbn) {
		for(int i = 0; i <bookList.size(); i++) {
            if(bookList.get(i).getIsbn().equals(isbn)) {
            	bookList.remove(i);
                break;
            }
		}	
	}
	
	@Override
	public ArrayList<Book> getList() {
		return bookList;
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getIsbn().equals(isbn)) return bookList.get(i);
		}
		return null;
	}
	
	@Override
	public ArrayList<Book> searchByTitle(String keyword) {
		int cnt=0;
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getTitle().contains(keyword)) {
				cnt++;
				return bookList;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> book= new ArrayList<>();
		for(Book b : bookList) {
			if(b instanceof Magazine) continue;
			else book.add(b);
		}
		return book;
	}
	
	//getClass는 new할때 사용했던 클래스가 누구인지
	
	//instaceof: 해당 객체가 이 클래스 타입으로 참조가 가능한지?
	//			Magazine 혹은 그 자식클래스의 객체로 생성됐는지?
	@Override
	public ArrayList<Book> getMagazines() {
		ArrayList<Book> magazine = new ArrayList<>();
		for(Book b : bookList) {
			if(b instanceof Magazine) magazine.add(b);
		}
		return magazine;
	}
	
	
	@Override
	public int getTotalPrice() {
		int sum=0;
		for(int i = 0; i < bookList.size(); i++) {
			sum+=bookList.get(i).getPrice();
		}
		return sum;
	}
	
	@Override
	public double getPriceAvg() {
		return getTotalPrice()/bookList.size();
	}
	
	
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		boolean isOk=false;
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getIsbn().equals(isbn)) {
				bookList.get(i).setQuantity(bookList.get(i).getQuantity()+quantity);
				isOk = true;
			}
		}
		if(!isOk)
			throw new ISBNNotFoundException(isbn);
		
	}
	
	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		boolean isOk=false;
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getIsbn().equals(isbn)) {
				if(bookList.get(i).getQuantity() >= quantity) {
					bookList.get(i).setQuantity(bookList.get(i).getQuantity()-quantity);
					isOk=true;
				}
			}
		}
		if(!isOk) {
			throw new QuantityException();
		}
	}
	

}
