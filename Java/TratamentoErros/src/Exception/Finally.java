package Exception;

import java.util.Scanner;

public class Finally {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		try {
			
			System.out.println(7 / in.nextInt());
			
			in.close();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally { //sempre e chamado o finally
			
			System.out.println("finally");
			
			in.close();
			
		}
		
	}

}
