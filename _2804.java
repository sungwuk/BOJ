import java.util.*;
public class _2804 {
	public static void main(String[] args) {
		String A,B;
		boolean flag=false;
		int x=-1,y=-1;
		Scanner scan = new Scanner(System.in);
		A=scan.next();B=scan.next();
		for(int i=0;i<A.length();i++) {
			char a = A.charAt(i);
			for(int j=0;j<B.length();j++) {
				if(a==B.charAt(j)) {
					x=i;y=j;flag=true;
					break;
				}
			}
			if(flag)break;
		}
		for(int i=0;i<B.length();i++) {
			for(int j=0;j<A.length();j++) {
				if(j==x) {
					System.out.print(B.charAt(i));
					continue;
				}
				if(i==y) {
					System.out.print(A.charAt(j));
				}
				else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
}