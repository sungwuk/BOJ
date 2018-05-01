import java.util.*;
public class _3806 {
	static int solve(String s, String t) {
		int count=0;

		int s_0=0,s_1=0,t_0=0,t_1=0;
		for(int i=0;i<s.length();i++) {
			if(s.length()!=t.length()) return -1;
			if((int)s.charAt(i)==49) {				//34 == ascii코드 1
				s_1++;
			}
			if((int)s.charAt(i)==48) {
				s_0++;
			}
			if((int)t.charAt(i)==48) {
				t_0++;
			}
			if((int)t.charAt(i)==49) {
				t_1++;
			}
		}
		char[] a=s.toCharArray();
		for(int i=0;i<s.length();i++) {			 //? 표시 찾아서 숫자로 바꾸는 부분
			if((int)s.charAt(i)==63) {				 //63==? ascii
				if((int)t.charAt(i)==48) {			 //t의 i번쨰가 0인경우
					if(s_0<t_0) {
						a[i]=48;
						s_0++;
						count++;
						s= new String(a);
					}
					else {
						a[i]=49;
						s_1++;
						count++;
						s= new String(a);
					}
				}
				else {
					if(s_1<t_1) {
						a[i]=49;
						s_1++;
						count++;
						s= new String(a);
					}
					else {
						a[i]=48;
						s_0++;
						count++;
						s= new String(a);
					}
				}
			}
		}
		if(s_0!=t_0||s_1!=t.length()-t_0) {
			if(s_1>t_1) return -1;
			else {
				for(int i=0;i<s.length();i++) {
					if((int)s.charAt(i)==48&&(int)t.charAt(i)==49) {
						a[i]=49;
						count++;
						s=new String(a);
					}
				}
				return count;
			}
		}
		int d=0;
		for(int i=0;i<s.length();i++) {
			if((int)s.charAt(i)!=(int)t.charAt(i)) {
				if((int)t.charAt(i)==48) {
					a[i]=48;
					s= new String(a);
				}
				else {
					a[i]=49;
					s= new String(a);
				}
				d++;
			}
		}
		count+=d/2;
		return count;
	}
	public static void main(String[] args) {
		String S,T;int N;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		for(int i=1;i<=N;i++) {
			S = scan.next();T=scan.next();
			System.out.println("Case "+i+": "+solve(S,T));
		}
	}
}