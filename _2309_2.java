import java.util.*;
public class _2309 {
	static boolean chk[]= new boolean[9],flag=true;
	static int arr[]= new int[9];
	static int calc() {
		int ki=0;
		for(int i=0;i<9;i++) {
			if(chk[i]) {
				ki+=arr[i];
			}
		}
		return ki;
	}
	static void solve(int c,int dep) {
		if(c==7) {
			int result=calc();
			if(result==100) {
				LinkedList<Integer>l=new LinkedList<>();
				for(int i=0;i<9;i++) {
					if(chk[i]) l.add(arr[i]);
				}
				Collections.sort(l);
				for(int a: l) System.out.println(a);
				flag=false;
				return ;
			}
		}
		else {
			for(int i=dep;i<9;i++) {
				chk[i]=true; 		//i번쨰 난쟁이 고름
				solve(c+1,i+1);
				if(!flag) break;
				chk[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		solve(0,0);
	}
}