import java.util.*;
public class _9663 {
	static boolean [] col,check_1,check_2;
	static int n=0,dap=0;
	static void solve(int choice) {
		if(choice>n) {
			dap++; 
			return;
		}
		for(int i=1; i<=n;i++) {
			if(!col[i]&&!check_1[n+(choice-i)+1]&&!check_2[i+choice]) {
				col[i]=check_1[n+(choice-i)+1]=check_2[i+choice]=true;
				solve(choice+1);
				col[i]=check_1[n+(choice-i)+1]=check_2[i+choice]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=  sc.nextInt();
		col = new boolean[16];
		check_1= new boolean[40];     // 감소하는 방향 대각선
		check_2 = new boolean[40];	// 증가하는 방향 대각선
		solve(1);
		System.out.println(dap);
	}

}
