import java.util.Scanner;


public class BankApplication {
	public static Account[] accountArray=new Account[100];
	public static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean run=true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("-------------------------------------------");
			System.out.print("����>");
		
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
		System.out.println("���α׷� ����.");
	}

	private static void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("-------");
		System.out.println("���� ���");
		System.out.println("-------");
		
		for(int i=0; i<accountArray.length; i++) {
			Account existAccount=accountArray[i];
			
			System.out.print("���¹�ȣ: ");
			String num=scan.next();
			System.out.print("��ݾ� : ");
			int withdrawNum=scan.nextInt();
			
			Account existAccount1 =findAccount(num);
			if(existAccount1==null) {
				System.out.println("��� : ����� ��ҵǾ����ϴ�.");
				return;
			}else {
				if(existAccount1.getBalance()<withdrawNum) {
					System.out.println("�ܾ��� �����մϴ�.");
				}else {
					int existNum=existAccount1.getBalance();
					existNum-=withdrawNum;
					existAccount1.setBalance(existNum);
					System.out.println("��� : ����� �����Ǿ����ϴ�.");
					break;
				}
			}
		}
		
	}

	private static void deposit() {
		// TODO Auto-generated method stub
		System.out.println("-------");
		System.out.println("���� ����");
		System.out.println("-------");
		
		for(int i=0; i<accountArray.length; i++) {
			Account existAccount=accountArray[i];
			
			System.out.print("���¹�ȣ: ");
			String num=scan.next();
			System.out.print("���ݾ�: ");
			int depositNum=scan.nextInt();
			
			Account existAccount1 =findAccount(num);
			if(existAccount1==null) {
				System.out.println("��� : ������ ��ҵǾ����ϴ�.");
				return;
			}else {
				int existNum=existAccount1.getBalance();
				existNum+=depositNum;
				existAccount1.setBalance(existNum);
				System.out.println("��� : ������ �����Ǿ����ϴ�.");
				break;
			}
		
		}
	}

	private static void accountList() {
		// TODO Auto-generated method stub
		System.out.println("-------");
		System.out.println("���� ���");
		System.out.println("-------");
		
		
		for(int i=0; i<accountArray.length; i++) {
			Account existAccount=accountArray[i];

			if(existAccount!=null) { 
				System.out.println("���¹�ȣ: " + existAccount.getAno());
				System.out.println("������: " + existAccount.getOwner());
				System.out.println("�ʱ��Աݾ�: " + existAccount.getBalance());
				System.out.println(" ");
			}
			if(accountArray[i]==null) {
				break;
			}
		}
	}

	private static void createAccount() {
		// TODO Auto-generated method stub
		//���� ����
		System.out.println("-------");
		System.out.println("���� ����");
		System.out.println("-------");
		
		System.out.print("���¹�ȣ: ");
		String num=scan.next();
		System.out.print("������: ");
		String name=scan.next();
		System.out.print("�ʱ��Աݾ�: ");
		int firstDe=scan.nextInt();
		
		Account newAccount=new Account(num, name, firstDe);
		
		for(int i=0; i<accountArray.length; i++) {
		
			if(accountArray[i]==null) {
				accountArray[i] = newAccount;
				System.out.println("��� : ���°� �����Ǿ����ϴ�.");
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
