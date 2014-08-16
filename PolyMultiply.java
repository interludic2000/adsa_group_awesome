
public class PolyMultiply {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * Answer should be 4, 14, 28, 27, 18 
		 */
		int[] p = {1, 2, 3};
		int[] q = {4, 5, 6};
		int[] r = new int[p.length*2];
		
		r = PolyMulti(p,q);
		for(int i = 0; i < r.length; i++){
			System.out.println("r[" +i + "] = " + r[i]);
		}
		
		
	}

	
	public static int[] PolyMulti(int[] p, int[] q){
		System.out.println("--- Function Called ---");
		for(int i = 0; i < p.length; i++){
			System.out.println("p[" +i + "] = " + p[i]);
		}
		for(int i = 0; i < q.length; i++){
			System.out.println("q[" +i + "] = " + q[i]);
		}
		
		assert(p.length == q.length);
		
		
		/*
		 * Base case
		 */
		if (p.length <= 1 && q.length <=1){
			int[] r = new int[p.length];
			r[0] = multiply(p[0],q[0]);
			return r;
		}
		
	
		int p1_len= p.length/2;
		int[] p1 = new int[p1_len];
		int[] p2 = new int[p.length - p1_len];
			
		if(p.length > 1){
			/*
			 * Split p into p1 and p2
			 */
			int k = p.length/2;
			for (int i = 0; i < k; i++) 
				p1[i] = p[i];
			
			for (int i = 0; i < (p.length-k); i++) 
				p2[i] = p[k+i];	
		}
	
		/*
		 * Split q into q1 and q2
		 */
		int q1_len = q.length/2;
		int[] q1 = new int[q1_len];
		int[] q2 = new int[q.length - q1_len];
		
		if(q.length > 1){

			int l = q.length/2;
			for (int i = 0; i < l; i++) 
				q1[i] = q[i];
			
			for (int i = 0; i < (q.length-l); i++) 
				q2[i] = q[l+i];
		}
		
		/*
		 * Recursive call
		 */
		int A[] = PolyMulti(p1,q1);
		int C[] = PolyMulti(p2,q2);
		
		/*
		 * Calculate (p1(x) + p2(x))
		 */
		int[] p3 = new int[p1.length];
		for(int i = 0; i < p1.length; i++){
			p3[i] = p1[i] + p2[i];
			System.out.println("p3[" + i + "] = " + p3[i]);
		}
		
		/*
		 * Calculate (q1(x) + q2(x))
		 */
		int[] q3 = new int[q1.length];
		for(int i = 0; i < q1.length; i++){
			q3[i] = q1[i] + q2[i];
			System.out.println("q3[" + i + "] = " + q3[i]);
		}
		
		/*
		 * Call B(x) = ((p1(x) + p2(x)) x ((q1(x) + q2(x)) - A(x) - C(x)
		 * I think the issue in here, maybe.
		 */
		int B[] = new int[p1.length+p2.length]; 
		B =	PolyMulti(p3,q3);
		B[0] = B[0] - A[0] - C[0];

		
		/*
		 * Put A B and C into array r 
		 * 
		 */
		int[] r = new int[A.length + B.length + C.length];
		for(int i = 0; i < A.length; i++){
			r[i] = A[i];
		}

		for(int i = 0; i < B.length; i++){
			r[i+A.length] = B[i];
		}
		
		for(int i = 0; i < C.length; i++){
			r[i+A.length+B.length] = C[i];
		}
		
		return r;
	}
	
	public static int multiply(int a, int b){
		System.out.println(a + " x " + b);
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

	
