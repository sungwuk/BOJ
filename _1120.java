import java.util.*;
public class _1120 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a=sc.next(),b=sc.next();
		int dap=Integer.MAX_VALUE;
		for(int i=0;i<=(b.length()-a.length());i++) {
			int count=0;
			for(int j=0,k=i;j<a.length();j++,k++) {
				if(a.charAt(j)!=b.charAt(k))count++;
			}
			dap = Math.min(dap, count);
		}
		System.out.println(dap);
	}
}