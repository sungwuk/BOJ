import java.util.*;
public class _2160 {
	static char map[][];
	static int n,dap=Integer.MAX_VALUE,da=-1,db=-1;
	static boolean chk[];
	static LinkedList<Integer> list;
	static int calc() {
		int diff=0;
		list= new LinkedList<>();
		for(int i=0;i<n;i++) if(chk[i]) list.add(i);
		int a=list.poll(),b=list.poll();
		String sa="",sb="";
		for(int i=a*5;i<a*5+5;i++) {
				String s = new String(map[i]);
				sa=sa.concat(String.valueOf(s));
		}
		for(int i=b*5;i<b*5+5;i++) {
			String s = new String(map[i]);
				sb=sb.concat(String.valueOf(s));
		}
		for(int i=0;i<35;i++) {
			if(sa.charAt(i)!=sb.charAt(i)) diff++;
		}
		list.push(a);list.push(b);
		return diff;
	}
	static void solve(int c,int dep) {
		if(c==2) {
			int a=calc();
			if(dap>a) {
				Collections.sort(list);
				da=list.poll();db = list.poll();
				dap=a;
			}
	
		}
		else {
			for(int i=dep;i<n;i++) {
				if(!chk[i]) {
					chk[i]=true;
					solve(c+1,dep+1);
					chk[i]=false;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		chk = new boolean[n];map = new char[n*5][7];
		for(int i=0;i<5*n;i++) {
			String a = sc.next();
			for(int j=0;j<7;j++) {
				map[i][j]=a.charAt(j);
			}
		}
		solve(0,0);
		System.out.println((da+1)+" "+(db+1));
	}
}