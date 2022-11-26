package Examples;


public class playground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(mystery(4));
		

		
	}
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int mystery(int n) {
		if(n==0){
			return 0;
		}
		else{
			return n*n+mystery(n-1);
		}
	}
	
}
