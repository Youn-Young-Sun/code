package com.ssafy.ws03.step3;

import java.util.Scanner;

public class BookTest {
			
	        Book[] books = new Book[1000];
	        int idx = 0;
	public static void main(String[] args) {
		/*Book b1=new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본문법");
		Book b2=new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링");
		
		System.out.println("***********************도서목록***********************");
		System.out.println(b1);
		System.out.println(b2);*/
		
		Scanner sc = new Scanner(System.in);

	        while(true) {
	            System.out.println("1. 책 추가.");
	            System.out.println("2. 모든 책 조회.");
	            System.out.println("3. 책 제목 수정.");
	            System.out.println("4. 책 삭제.");
	            System.out.println("0. 종료.");
	            int sel = sc.nextInt();
	            if(sel == 0)
	                break;
	            else if(sel == 1) {
	                //isbn번호 사용자로부터 입력.
	                System.out.print("isbn번호 : ");
	                String isbn = sc.next();
	                //title 사용자로부터 입력.
	                System.out.print("제목 : ");
	                String title = sc.next();
	                //author 사용자로부터 입력.
	                System.out.print("저자 : ");
	                String author = sc.next();
	                //publisher 사용자로부터 입력
	                System.out.print("출판사 : ");
	                String publisher = sc.next();
	                //price 사용자로부터 입력
	                System.out.print("가격 : ");
	                int price = sc.nextInt();
	                //desc 사용자로부터 입력.
	                System.out.print("설명 : ");
	                String desc = sc.next();
	                //입력받은 정보들로 book객체 생성해 idx번째 변수에 객체 생성
	                books[idx++] = new Book(isbn, title, author, publisher, price, desc);
	            }
	            else if(sel == 2) {
	                //모든 입력받은 책의 정보를 출력.
	                for(int i = 0; i < idx; i++)
	                    System.out.println(books[i]);
	            }
	            else if(sel == 3) {
	                //isbn번호를 입력받는다.
	                //제목을 입력받는다.
	                //입력받은 isbn번호인 책을 찾아서 제목을 입력받은걸로 바꾼다.

	                System.out.print("isbn번호 : ");
	                String isbn = sc.next();
	                System.out.print("제목 : ");
	                String title = sc.next();
	                for(int i = 0; i < idx; i++) {
	                    if( books[i].getIsbn().equals(isbn) )
	                        books[i].setTitle(title);
	                }
	            }
	            else if(sel == 4) {
	                //삭제할 isbn을 입력받는다.
	                //반복을 돌면서 isbn에 해당하는 책을 찾아서
	                System.out.print("isbn번호 : ");
	                String isbn = sc.next();
	                for(int i = 0; i < idx; i++) {
	                    if(books[i].getIsbn().equals(isbn)) {
	                        books[i] = books[idx-1];
	                        idx--;
	                        break;
	                    }
	                }
	            }
	       }
	}
}


