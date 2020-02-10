package prob5;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo, int balance) {
		this.accountNo = accountNo;
		this.balance=balance;
		
		System.out.println(this.accountNo+" 계좌가 개설되었습니다.");
		System.out.println(this.accountNo+" 계좌의 잔고는 "+this.balance+"만원입니다.");
	}
	
	public void save(int money) {
		this.balance += money;
		System.out.println(accountNo +" 계좌에 "+ money +"만원이 입금되었습니다.");
		System.out.println(accountNo +" 잔고는 "+ balance +"만원입니다.");
	}
	
	public void deposit(int money) {
		this.balance -= money;	
		System.out.println(accountNo +" 계좌에 "+ money +"만원이 출금되었습니다.");
		System.out.println(accountNo +" 잔고는 "+ balance +"만원입니다.");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
