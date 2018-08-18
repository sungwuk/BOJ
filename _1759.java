import java.util.*;
public class _1759 {
	static int l,c;
	static boolean[] check,isc;
	static char[] input ;
	static int count=0;
	static void calc() {
		for(int i=0;i<c;i++) {
			if(check[i])System.out.print(input[i]);
		}
		System.out.println();
	}
	static void solve(int dep, int a) {
		if(a==l) {
			if(count>=1&&l-count>=2) {
				calc();
			}
		}
		else {
			for(int i=dep+1;i<c;i++) {
				check[i]=true;
				if(isc[i]) count++;			
				solve(i,a+1);
				if(isc[i]) count--;	
				check[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l=sc.nextInt();c=sc.nextInt();
		isc = new boolean[c];
		check= new boolean[c];
		input = new char[c];
		for(int i=0;i<c;i++) {
			input[i]=sc.next().charAt(0);
		}
		Arrays.sort(input);
		for(int i=0;i<c;i++) {
			if(input[i]=='a'||input[i]=='e'||input[i]=='i'||input[i]=='o'||input[i]=='u') {
				isc[i]=true;
			}
		}
		solve(-1,0);
	}
}