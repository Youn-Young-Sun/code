package com.ssafy.ws04.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.ssafy.ws04.step3.Book;

public class BookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookManagerImpl mng = BookManagerImpl.getInstance();
		
		while(true) {
            System.out.println("1. 책 추가.");
            System.out.println("2. 책 제거.");
            System.out.println("3. 책 리스트 .");
            System.out.println("4. 고유번호로 책 찾기.");
            System.out.println("5. 제목으로 책 찾기.");
            System.out.println("6. 일반도서 목록.");
            System.out.println("7. 잡지 목록.");
            System.out.println("8. 도서 가격 총합.");
            System.out.println("9. 도서 가격 평균.");
            System.out.println("10. 도서 구매.");
            System.out.println("11. 도서 판매.");
            System.out.println("0. 종료.");
            int sel = sc.nextInt();
           
            if(sel == 0) break;
            
            else if(sel == 1) { //책 추가
                System.out.print("isbn번호 : ");
                String isbn = sc.next();         
                System.out.print("제목 : ");
                String title = sc.next();
                System.out.print("저자 : ");
                String author = sc.next();
                System.out.print("출판사 : ");
                String publisher = sc.next();
                System.out.print("설명 : ");
                String desc = sc.next();
                System.out.print("가격 : ");
                int price = sc.nextInt();
                System.out.print("재고 : ");
                int quantity= sc.nextInt();
                System.out.print("잡지? (1: 예, 0: 아니오) ");
                int isMagazine = sc.nextInt();
                if(isMagazine == 1) {
                   System.out.print("year: ");
                   int year = sc.nextInt();
                   System.out.print("month: ");
                   int month = sc.nextInt();
         
                mng.add(new Magazine(isbn, title, author, publisher, desc, price, quantity, year, month));
                } 
                else {
               mng.add(new Book(isbn, title, author, publisher,desc, price,quantity));
                }               
            }
            
            else if(sel == 2) { //책 삭제
            	System.out.print("isbn번호 : ");
                String isbn = sc.next();
                System.out.println("***********************도서삭제:"+isbn+"***********************");
                mng.remove(isbn);
            }
            
            else if(sel == 3) { //책 리스트
            	System.out.println("***********************도서목록***********************");
            	System.out.println(mng.getList());
            	}
            
               
           else if(sel == 4) { //고유번호로 책 찾기   
        	   System.out.print("isbn번호 : ");
               String isbn = sc.next();
               System.out.println("***********************도서조회:"+isbn+"***********************");
               System.out.println(mng.searchByIsbn(isbn));
               System.out.println();
           }
           else if(sel == 5) { //제목으로 책 찾기  
        	   System.out.print("도서 제목 포함 검색 : ");
               String keyword = sc.next();
               System.out.println("***********************도서조회:"+keyword+"***********************");
               System.out.println(mng.searchByTitle(keyword));
               System.out.println();
           }
           else if(sel == 6) { // 일반도서 목록  
               System.out.println("***********************일반 도서 목록***********************");
               System.out.println(mng.getBooks());
               System.out.println();
           }
           else if(sel == 7) { //잡지 목록  
               System.out.println("***********************잡지 목록***********************");
               System.out.println(mng.getMagazines());
               System.out.println();
           }
           else if(sel == 8) { //도서 가격 총합   
               System.out.println("도서 가격 총합: ");
               System.out.println(mng.getTotalPrice());
               System.out.println();
           }
           else if(sel == 9) { //도서 가격 평균   
               System.out.println("도서 가격 평균: ");
               System.out.println(mng.getPriceAvg());
               System.out.println();
           }
           else if(sel == 10) { //도서 구매   
        	   System.out.println("isbn번호 : ");
               String isbn = sc.next();
               System.out.println("구매 개수 : ");
               int quantity = sc.nextInt();
        	   System.out.println("***********************도서구매:"+isbn+","+quantity+"개***********************");
        	   try {
        		   System.out.println(mng.buy(isbn, quantity));
        	   } catch (ISBNNotFoundException e) {
        		   System.out.println("존재하지 않는 ISBN번호 입니다.");
        	   }
               System.out.println();
           }
            
           else if(sel == 11) { //도서 판매   
        	   System.out.println("isbn번호 : ");
               String isbn = sc.next();
               System.out.println("판매 개수 : ");
               int quantity = sc.nextInt();
        	   System.out.println("***********************도서판매:"+isbn+","+quantity+"개***********************");
        	   try {
        		  mng.sell(isbn, quantity);
        	   } catch (ISBNNotFoundException e) {
        		   System.out.println("존재하지 않는 ISBN번호 입니다.");
        	   } catch (QuantityException e) {
               System.out.println("수량이 부족합니다.");
        	   } 
               System.out.println();
           }

		}
		
	}
}