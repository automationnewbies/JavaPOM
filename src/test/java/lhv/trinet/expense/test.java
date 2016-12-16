package lhv.trinet.expense;

public class test {
	
	public static void main(String args[])
	{
		String input = "insert %s in the string"; // here %s is the placeholder
		input = String.format(input, "Con điên"); 
		System.out.print(input);
	}

}
