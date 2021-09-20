import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        Bank[] banks = new Bank[1000];
        int idx = 0;
        int sum = 0;

        while(true) {
            System.out.println("1. 회원 추가.");
            System.out.println("2. 모든 회원 조회.");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 회원 삭제.");
            System.out.println("0. 종료.");
            int sel = sc.nextInt();
            if(sel == 0)
                break;
            else if(sel == 1) {             
                System.out.print("accountNumber : ");
                String accountNumber = sc.next();
                System.out.print("이름 : ");
                String name = sc.next();
                System.out.print("잔고 : ");
                int amount = sc.nextInt();
            
                banks[idx++] = new Bank(accountNumber, name,amount);
                System.out.println(name+"님의 계좌가 생성되었습니다.");
            }
            else if(sel == 2) {
            	System.out.println("*******************회원목록*******************");
                System.out.println("name \t|  accountNumber \t|  amount \t|");
                System.out.println("-----------------------------------------------");
                for(int i = 0; i < idx; i++)
                    System.out.println(banks[i]);
            }
            else if(sel == 3) {//입금
            	System.out.print("accountNumber : ");
                String accountNumber = sc.next();
                System.out.print("입금할 금액 : ");
                int deposit=sc.nextInt();
                for(int i = 0; i < idx; i++) {
                    if( banks[i].getAccountNumber().equals(accountNumber) ) {
                        sum=banks[i].getAmount() + deposit;
                    	banks[i].setAmount(sum);
                    	System.out.println("입금후 잔고: "+sum);
                    	break;
                    	}
                   }
            }
            
            else if(sel == 4) {//출금
            	System.out.print("accountNumber : ");
                String accountNumber = sc.next();
                System.out.print("출금할 금액 : ");
                int withdraw=sc.nextInt();
                for(int i = 0; i < idx; i++) {
                    if( banks[i].getAccountNumber().equals(accountNumber) ) {
                        sum=banks[i].getAmount() - withdraw;
                    	banks[i].setAmount(sum);
                    	System.out.println("출금후 잔고: "+banks[i].getAmount());
                    	break;
                    }                    	
                }
            }
            else if(sel == 5) {
                System.out.print("accountNumber : ");
                String accountNumber = sc.next();
               
                for(int i = 0; i < idx; i++) {
                    if(banks[i].getAccountNumber().equals(accountNumber)) {
                    	System.out.println(banks[i].getName() + "님의 계좌를 삭제합니다.");
                    	banks[i] = banks[idx-1];
                        idx--;
                        break;
                    }
                }
            }
        }
    }
}

