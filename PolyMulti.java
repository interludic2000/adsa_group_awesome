/*
 * ADSA Assignment 2, question 3
 * 
 * a1077337 Xiang Guo
 * a1646630 Patrick Mann
 * 
 */

import java.rmi.RemoteException;

public class PolyMulti {

	/**
	 * @param args
	 */
	
	public static int[] polyMulti(int[] p, int[] q)throws RemoteException{
		int n = p.length;
		int m = q.length;
				
		/*
		 * Base case
		 */

		if (n <= 1 && m <=1){
			int[] r = new int[1];
			r[0] = multiply(p[0],q[0]);
			return r;
		}

		/*
		 * Split p into p1 and p2
		 */
		int p1_len= n/2;
		int[] p1 = new int[p1_len];
		int[] p2 = new int[n - p1_len];
			
		if(n > 1){
			int k = n/2;
			for (int i = 0; i < k; i++) 
				p1[i] = p[i];
			
			for (int i = 0; i < (n-k); i++) 
				p2[i] = p[k+i];	
		}
	
		/*
		 * Split q into q1 and q2
		 */
		int q1_len = m/2;
		int[] q1 = new int[q1_len];
		int[] q2 = new int[m - q1_len];

		if(m > 1){
			int l = m/2;
			for (int i = 0; i < l; i++) 
				q1[i] = q[i];
			
			for (int i = 0; i < (m-l); i++) 
				q2[i] = q[l+i];
		}

		
		/*
		 * Recursive call
		 */
		int A[] = polyMulti(p1,q1);
		int C[] = polyMulti(p2,q2);
		
		/*
		 * Calculate (p1(x) + p2(x))
		 */
		int[] p3 = new int[max(p1.length,p2.length)];

		for(int i = 0; i < q1.length; i++){
			p3[i] = p1[i] + p2[i];
			if(p1.length<p2.length){
				p3[i+1] = 0 + p2[i+1];
			}
		}

		/*
		 * Calculate (q1(x) + q2(x))
		 */
		int[] q3 = new int[max(q1.length,q2.length)];
		
		for(int i = 0; i < q1.length; i++){
			q3[i] = q1[i] + q2[i];
			if(q1.length<q2.length)
				q3[i+1] = 0 + q2[i+1];
		}
		
		/*
		 * Call B(x) = ((p1(x) + p2(x)) x ((q1(x) + q2(x)) - A(x) - C(x)
		 * 
		 */
		int B[] = new int[p1.length+p2.length];
		B =	polyMulti(p3,q3);
		
		for( int i = 0; i < A.length ; i++){
			B[i] = B[i] - A[i];	
		}
		
		for( int i = 0; i < C.length ; i++){
			B[i] = B[i] - C[i];	
		}
		
		
		/*
		 * Put A B and C into array r 
		 * 
		 */
		int[] r = new int[n*2-1];
		
		for(int i = 0; i < A.length; i++){
			r[i] = r[i] + A[i];
		}

		for(int i = 0; i < B.length; i++){
			r[i+n/2] = r[i+n/2] + B[i];
		}
		
		for(int i = 0; i < C.length; i++){
			r[i+(n/2)*2] = r[i+(n/2)*2] + C[i];
		}
		
		return r;
	}
	
	public static int multiply(int a, int b){
		int c = a * b;
		return c;
	}
	
	public static int max(int a, int b){
		if(a > b)
			return a;
		else
			return b;
		
	}
}
