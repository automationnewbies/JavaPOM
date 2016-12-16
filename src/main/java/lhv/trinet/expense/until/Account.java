package lhv.trinet.expense.until;

public class Account {
	private final String email;
	private final String password;
	
	public static class Builder {
		private String email;
		private String password;
		
		public Builder email(String email){
			this.email = email;
			return this;
		}
		
		public Builder password(String password){
			this.password = password;
			return this;
		}
		
		public Account build(){
			return new Account(this);
		}
	}
	
	private Account(Builder builder)
	{
		this.email = builder.email;
		this.password = builder.password;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	@Override
	public String toString(){
		return "Account{email='"+email+"'; password='"+password+"'";
	}
		
}
