import java.util.Scanner;


public class BankApplication {
	public static Account[] accountArray=new Account[100];
	public static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean run=true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택>");
		
			int selectNo=scan.nextInt();
			
			if (selectNo==1) {
				createAccount();
			} else if(selectNo==2) {
				accountList();
			} else if(selectNo==3) {
				deposit();
			} else if(selectNo==4) {
				withdraw();
			} else if(selectNo==5) {
				run=false;
			}
		}
		System.out.println("프로그램 종료.");
	}

	private static void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("-------");
		System.out.println("계좌 출금");
		System.out.println("-------");
		
		for(int i=0; i<accountArray.length; i++) {
			Account existAccount=accountArray[i];
			
			System.out.print("계좌번호: ");
			String num=scan.next();
			System.out.print("출금액 : ");
			int withdrawNum=scan.nextInt();
			
			Account existAccount1 =findAccount(num);
			if(existAccount1==null) {
				System.out.println("결과 : 출금이 취소되었습니다.");
				return;
			}else {
				if(existAccount1.getBalance()<withdrawNum) {
					System.out.println("잔액이 부족합니다.");
				}else {
					int existNum=existAccount1.getBalance();
					existNum-=withdrawNum;
					existAccount1.setBalance(existNum);
					System.out.println("결과 : 출금이 성공되었습니다.");
					break;
				}
			}
		}
		
	}

	private static void deposit() {
		// TODO Auto-generated method stub
		System.out.println("-------");
		System.out.println("계좌 예금");
		System.out.println("-------");
		
		for(int i=0; i<accountArray.length; i++) {
			Account existAccount=accountArray[i];
			
			System.out.print("계좌번호: ");
			String num=scan.next();
			System.out.print("예금액: ");
			int depositNum=scan.nextInt();
			
			Account existAccount1 =findAccount(num);
			if(existAccount1==null) {
				System.out.println("결과 : 예금이 취소되었습니다.");
				return;
			}else {
				int existNum=existAccount1.getBalance();
				existNum+=depositNum;
				existAccount1.setBalance(existNum);
				System.out.println("결과 : 예금이 성공되었습니다.");
				break;
			}
		
		}
	}

	private static void accountList() {
		// TODO Auto-generated method stub
		System.out.println("-------");
		System.out.println("계좌 목록");
		System.out.println("-------");
		
		
		for(int i=0; i<accountArray.length; i++) {
			Account existAccount=accountArray[i];

			if(existAccount!=null) { 
				System.out.println("계좌번호: " + existAccount.getAno());
				System.out.println("계좌주: " + existAccount.getOwner());
				System.out.println("초기입금액: " + existAccount.getBalance());
				System.out.println(" ");
			}
			if(accountArray[i]==null) {
				break;
			}
		}
	}

	private static void createAccount() {
		// TODO Auto-generated method stub
		//게좌 생성
		System.out.println("-------");
		System.out.println("계좌 생성");
		System.out.println("-------");
		
		System.out.print("계좌번호: ");
		String num=scan.next();
		System.out.print("계좌주: ");
		String name=scan.next();
		System.out.print("초기입금액: ");
		int firstDe=scan.nextInt();
		
		Account newAccount=new Account(num, name, firstDe);
		
		for(int i=0; i<accountArray.length; i++) {
		
			if(accountArray[i]==null) {
				accountArray[i] = newAccount;
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
		
		}
		
	}
	private static Account findAccount(String ano) {
		Account account=null;
		for (int i=0; i<accountArray.length; i++) {
			if(accountArray[i]==null) {
				break;
			} else {
				String num = accountArray[i].getAno();
				if(num.equals(ano)) {
					account=accountArray[i];
					break;
				}
			}
		}
		return account;
		
	}
	
	

}
