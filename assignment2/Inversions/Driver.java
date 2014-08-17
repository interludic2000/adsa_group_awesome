public class Driver {
	public static void main(String[] args) {

		InversionNumber program = new InversionNumber();

		int[] values = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		int results = program.getInversionNumber(values);

		System.out.println("Inversions: " + results);


	}
}