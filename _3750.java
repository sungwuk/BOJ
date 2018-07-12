package fg;
import java.util.*;
public class _3750 {
	static void solve(String in) {
		
		if(in.length()==1) {
			System.out.println(" "+in);
			return;
		}
		else {
			int a=0;
			char[] out = in.toCharArray();
			for(int i=0;i<in.length();i++) {
				a+=Character.getNumericValue(out[i]);
			}
			solve(String.valueOf(a));
		}
	}
	public static void main(String[] args) {
		String input;
		Scanner sc = new Scanner(System.in);
		int t;
		t=sc.nextInt();
		for(int i=1;i<=t;i++) {
			input = sc.next();
			System.out.print("#"+i);
			solve(input);
		}
	}

}
