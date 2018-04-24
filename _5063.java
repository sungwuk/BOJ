import java.util.*;
public class _5063 {
	public static void main(String[] args) {
		int N,r,e,c;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		while(N>0) {
			r=scan.nextInt();e=scan.nextInt();c=scan.nextInt();
			int sub = e-c;
			if(r>sub) System.out.println("do not advertise");
			else if(r<sub) System.out.println("advertise");
			else System.out.println("does not matter");		
			N--;
		}
	}
}
