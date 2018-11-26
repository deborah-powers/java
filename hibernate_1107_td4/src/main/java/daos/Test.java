package daos;

public class Test {

	public static void main(String[] args) {
		System.out.println("je suis le main");
		testCmd();
	}

	private static void testCmd() {
		DaoCommande Dcmd = new DaoCommande();
		Dcmd.test();
		Dcmd.close();
	}
}
