package Product;

import java.util.Scanner;


public class ProductTest {

	public static void main(String[] args) {	
		IProductMgr pMgr=ProductMgr.getInstance();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
            System.out.println("1. 상품 추가.");
            System.out.println("2. 상품 정보 검색.");
            System.out.println("3. 상품 번호로 검색.");
            System.out.println("4. 상품명으로 검색.");
            System.out.println("5. TV만 검색.");
            System.out.println("6. Refigerator만 검색.");
            System.out.println("7. 상품번호로 상품 삭제.");
            System.out.println("8. 전체 재고 상품 금액.");
            System.out.println("0. 종료.");
            int sel = sc.nextInt();
            if(sel == 0)
                break;
            if(sel==1) { //상품 추가 num, price, mount, name
            	 System.out.print("num : ");
                 String num = sc.next();
                
                 System.out.print("price : ");
                 int price = sc.nextInt();

                 System.out.print("amount : ");
                 int amount = sc.nextInt();

                 System.out.print("name : ");
                 String name = sc.next();
                 
                 Product product = new Product(num,price,amount,name);
                 pMgr.add(product);
            }
            if(sel==2) { //상품 정보 검색
            	for(Product P: pMgr.getProductList())	
            		System.out.println(P);
            }
            if(sel==3) { //상품 번호로 검색
            	System.out.print("상품 번호 : ");
                String num = sc.next();
                
                pMgr.getProductByNum(num);
                System.out.println();
            }
            if(sel==4) { //상품명으로 검색
            	System.out.print("상품명 : ");
                String name = sc.next();
                
                pMgr.getProductByName(name);
                System.out.println();
            }
            if(sel==5) { //TV만 검색
            	for(Product P: pMgr.getTVList())	
            		System.out.println(P);
            }
            if(sel==6) { //Refigerator만 검색
            	for(Product P: pMgr.getRefrigeatorList())	
            		System.out.println(P);
            }
            if(sel==7) { //상품번호로 상품 삭제
            	System.out.print("상품번호 : ");
                String num = sc.next();
                pMgr.removeProductByNo(num);
            }
            if(sel==8) { //전체 재고 상품 금액
            	 pMgr.getTotalPrice();
            }
            
		}

	}

}
