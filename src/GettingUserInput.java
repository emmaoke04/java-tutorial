import java.util.Scanner;

public class GettingUserInput {

	public static void main(String[] args) {

		Scanner Keyboardinput = new Scanner(System.in);

		System.out.print("enter your name?  ");

		String name = Keyboardinput.nextLine();
		
		
		
		
		System.out.print("enter your age?  ");

		int num = Keyboardinput.nextInt();

		System.out.println("Hey " + num + ", you are " + name + " years" );

	}
}