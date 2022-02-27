import java.io.IOException;

public class Simulatir {
	
	public static void startSimulator()throws IOException, InterruptedException {
		
		
		//String n;
		
		
		
		
		
		Runtime.getRuntime().exec("xcrun simctl boot 446B22A4-870D-4BCF-A0FB-169C367762AE");
		Thread.sleep(8000);
	}


}
