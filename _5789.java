import java.util.*;
public class _5789 {

	public static void main(String[] args) {
		int N;String s;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		while(N-->0) {
			s=scan.next();
			int mid=(s.length()/2);
			if(s.charAt(mid-1)==s.charAt(mid)) System.out.println("Do-it");
			else System.out.println("Do-it-Not");
			
		}
	}

}
