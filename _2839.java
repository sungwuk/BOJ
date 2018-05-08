import java.util.*;
public class _2839 {
	static int div3(int n) {
		int count=0;
		while(n>0) {
			if(n%5==0&&n!=0) {n-=5;
			count++;
			}
			else {
				n-=3;
				count++;
			}
		}
		if(n<0) return -1;
		else return count;
	}
	static int div5(int n) {
		int count=0;
		while(n>0) {
			if(n%3==0&&n!=0) {
				n-=3;
				count++;
			}
			else {
				n-=5;
				count++;
			}
		}
		if(n<0) return -1;
		else return count;
	}
	public static void main(String[] args) {
		int N,a,b;
		Scanner scan = new Scanner(System.in);
		N= scan.nextInt();
		a=div3(N);
		b=div5(N);
		if(a==-1&&b==-1) System.out.println(-1);
		else if(a==-1||b==-1) {
			if(a>b) System.out.println(a);
			else System.out.println(b);			
		}
		else {
			if(a>b) System.out.println(b);
			else System.out.println(a);
		}
	}

}
