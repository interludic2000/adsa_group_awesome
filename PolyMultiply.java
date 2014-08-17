import java.util.Vector;


public class PolyMultiply {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * make vector 1,2,3
		 */
		Vector<Integer> p = new Vector<Integer>();
		p.add(1);
		p.add(2);
		p.add(3);
		
		Vector<Integer> q = new Vector<Integer>();
		q.add(4);
		q.add(5);
		q.add(6);
		
		Vector<Integer> r = new Vector<Integer>(p.size() * 2);	
		
		r = PolyMulti(p,q);
		
		for(int i = 0; i< r.size(); i++){
			System.out.println("r(" + i + ") = " + r.get(i));
		}
	}

	
	public static Vector<Integer> PolyMulti(Vector<Integer> p, Vector<Integer> q){
		System.out.println("--- Function Called ---");
		for(int i = 0; i < p.size(); i++){
			System.out.println("p[" +i + "] = " + p.get(i));
		}
		for(int i = 0; i < q.size(); i++){
			System.out.println("q[" +i + "] = " + q.get(i));
		}
		
		assert(p.size() == q.size());
		
		
		/*
		 * Base case
		 */
		if (p.size() <= 1 && q.size() <=1){
			Vector<Integer> r = new Vector<Integer>();;
			r.add(multiply(p.get(0),q.get(0)));
			return r;
		}
		

		int p1_len= p.size()/2;
		Vector<Integer> p1 = new Vector<Integer>(p1_len);
		Vector<Integer> p2 = new Vector<Integer>(p.size() - p1_len);

		
		if(p.size() > 1){
			/*
			 * Split p into p1 and p2
			 */
			int k = p.size()/2;

			for (int i = 0; i < k; i++) 
				p1.add(p.get(i));
			
			for (int i = 0; i < (p.size()-k); i++) 
				p2.add(p.get(k+i));	
		}
	

		int q1_len= q.size()/2;
		Vector<Integer> q1 = new Vector<Integer>(q1_len);
		Vector<Integer> q2 = new Vector<Integer>(q.size() - q1_len);
		
		if(q.size() > 1){
			/*
			 * Split p into p1 and p2
			 */
			int l = q.size()/2;
			for (int i = 0; i < l; i++) 
				q1.add(q.get(i));
			
			for (int i = 0; i < (q.size()-l); i++) 
				q2.add(q.get(l+i));	
		}
	
		/*
		 * Recursive call
		 */
		Vector<Integer> A = PolyMulti(p1,q1);
		Vector<Integer> C = PolyMulti(p2,q2);
		

		/*
		 * Calculate (p1(x) + p2(x))
		 */
		Vector<Integer> p3 = new Vector<Integer>(p2.size());
		for(int i = 0; i < p2.size(); i++){
			System.out.println("p2.size() = " + p2.size());
			if(p1.size() < p2.size() && p2.size() > 1 ){
				p1.add(0);
			}
	
			p3.add(p1.get(i) + p2.get(i));

			System.out.println("p3[" + i + "] = " + p3.get(i));
		}

		/*
		 * Calculate (q1(x) + q2(x))
		 */
		Vector<Integer> q3 = new Vector<Integer>(q2.size());
		for(int i = 0; i < q2.size(); i++){
			System.out.println("q2.size() = " + q2.size());
			if(q1.size() < q2.size() && q2.size() > 1 ){
				q1.add(0);
			}
			q3.add(q1.get(i) + q2.get(i));
			System.out.println("q3[" + i + "] = " + q3.get(i));
		}
		
		/*
		 * Call B(x) = ((p1(x) + p2(x)) x ((q1(x) + q2(x)) - A(x) - C(x)
		 */
		
		Vector<Integer> B = new Vector<Integer>(p1.size() + p2.size());
		B =	PolyMulti(p3,q3);
		
		B.set(0, B.get(0) - A.get(0) - C.get(0));

		
		/*
		 * Put A B and C into array r 
		 */
		
		Vector<Integer> r = new Vector<Integer>();
		for(int i = 0; i < A.size(); i++){
			r.add(A.get(i));
		}
		for(int i = 0; i < B.size(); i++){
			r.add(B.get(i));
		}
		
		for(int i = 0; i < C.size(); i++){
			r.add(C.get(i));
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

	
