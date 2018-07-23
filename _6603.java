import java.util.*;
public class _6603 {
	static int[] num;
	static int k;
	static boolean[]use;
	static void print() {
		for(int i=0;i<k;i++) {
			if(use[i]) System.out.print(num[i]+" ");
		}
	}
	static void solve(int choice, int dep) {
		if(choice==6) {
			print();
			System.out.println();
		}
		else {
			for(int i=dep+1;i<k;i++) {
				use[i]=true;
				solve(choice+1,i);
				use[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k=sc.nextInt();
		while(k!=0) {
			num = new int[k];
			use= new boolean[k];
			for(int i=0;i<k;i++) {
				num[i]=sc.nextInt();
			}
			solve(0,-1);
			k=sc.nextInt();
			System.out.println();
		}
		
	}
}
