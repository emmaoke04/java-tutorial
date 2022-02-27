import java.io.IOException;

public class startIt {


	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
			//Runtime.getRuntime().exec("xcrun simctl boot 446B22A4-870D-4BCF-A0FB-169C367762AE");
			Runtime.getRuntime().exec("open /Applications/Xcode.app/Contents/Developer/Applications/Simulator.app");
			Thread.sleep(8000);

		}
}

	


 


//xcrun simctl boot 446B22A4-870D-4BCF-A0FB-169C367762AE