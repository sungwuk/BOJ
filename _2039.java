import java.util.*;
public class _2039{
	static boolean ch[] = new boolean[10],flag=true;
	static int k[] = new int[10],sum=0;
	static LinkedList list = new LinkedList();
	static void calc() {
		for(int i=1;i<=9;i++) {
			if(ch[i]) sum+=k[i];
		}
	}
	static void solve(int c, int dep) {
		if(c==7) {
			calc();
			if(sum==100) {
				for(int i=1;i<=9;i++) {
					if(ch[i]) {
						list.add((int)k[i]);
					}
				}
				flag=false;
				return;
			}
		}
		else {
			for(int i=dep+1;i<=9;i++) {
				ch[i]=true;
				solve(c+1,i);
				if(!flag) return;
				ch[i]=false; sum=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=9;i++) {
			k[i]=sc.nextInt();
		}
		solve(0,0);
		Collections.sort(list);
		for(Object a : list) {
			System.out.println(a);
		}
	}
}