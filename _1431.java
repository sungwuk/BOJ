import java.util.*;
public class _1431 {
	static class Str implements Comparable<Str>{
		String s;
		Str(String s){
			this.s=s;
		}
		@Override
		public int compareTo(Str o) {
			if(this.s.length()==o.s.length()) {
				int A=0,B=0;
				for(int i=0;i<this.s.length();i++) {
					char in = this.s.substring(i, i+1).charAt(0);
					if((int)in>47&&(int)in<58) {
						A+=Integer.parseInt(Character.toString(in));
					}
				}
				for(int i=0;i<o.s.length();i++) {
					char in = o.s.substring(i, i+1).charAt(0);
					if((int)in>47&&(int)in<58) {
						B+=Integer.parseInt(Character.toString(in));
					}
				}
				if(A!=B) {
					if(A>B) return 1;
					else return -1;
				}
				else {
					return this.s.compareTo(o.s);
				}
			}
			return this.s.length()-o.s.length();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		Str arr[] = new Str[n];
		for(int i=0;i<n;i++) {
			arr[i] = new Str(sc.next());
		}
		Arrays.sort(arr);
		for(Str a : arr) System.out.println(a.s);
	}
}