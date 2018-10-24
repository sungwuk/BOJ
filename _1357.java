import java.util.*;
public class _1357 {
	static int rev(int a) {
		LinkedList<Integer> list = new LinkedList<>();
		for(;a!=0;a/=10) {
			int tmp = a%10;
			list.add(tmp);
		}
		while(true) {
			if(list.get(0)==0) {
				list.pollFirst();
			}
			else break;
		}
		int size = list.size();
		for(int i=size;i>=1;i--) {
			a+=(int)Math.pow(10, i-1)*list.get(size-i);
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt();
		System.out.println(rev(rev(a)+rev(b)));
	}
}