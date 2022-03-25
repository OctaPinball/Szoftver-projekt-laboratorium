package miscellaneous;

public class Main {
	public static void main(String[] args) {
		Tester tester = new Tester();
		Logger.enable();
		
		//tester.runTest();
		Virologist v = new Virologist();
		v.forgetAllAgent();
	}
}
