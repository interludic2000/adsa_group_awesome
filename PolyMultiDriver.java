/*
 * ADSA Assignment 2, question 3 driver
 * 
 * a1077337 Xiang Guo
 * a1646630 Patrick Man
 * 
 */


import java.util.Scanner;

public class PolyMultiDriver extends PolyMulti{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input;
		int n = 0;
		boolean validInput = false;
		do{
			System.out.print("Enter positive integer for array size: ");
			input = sc.nextLine();
			try{
				n = Integer.parseInt(input);
				if (n > 0)
					validInput = true;
			}
			catch(Exception e){
				System.out.println("Bad entry. Please enter integer");
			}
		}while(validInput == false);
		
		int[] p = new int[n];
		for(int i = 0; i<n ; i++){
			System.out.print("Enter p[" + i + "]: ");
			input = sc.nextLine();
			p[i] = Integer.parseInt(input);
		}
		
		int[] q = new int[n];
		for(int i = 0; i<n ; i++){
			System.out.print("Enter q[" + i + "]: ");
			input = sc.nextLine();
			q[i] = Integer.parseInt(input);
		}
		
		System.out.print("\n p[] = ");
		for(int i = 0; i < p.length; i++){
			System.out.print(p[i] + " ");
		}
		System.out.print("\n q[] = ");
		for(int i = 0; i < q.length; i++){
			System.out.print(q[i] + " ");
		}
		
		
		int[] r = new int[p.length * 2 - 1];
		
		try{
			r = polyMulti(p,q);
		}
		catch(Exception e){
			System.out.println("An error has occured");
		}
		
		System.out.print("\n result[] = ");
		for(int i = 0; i < r.length; i++){
			System.out.print(r[i] + " ");
		}
		sc.close();
	}
}
