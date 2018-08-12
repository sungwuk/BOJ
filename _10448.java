import java.util.*;
public class _10448 {
	static boolean check[],flag=false;
	static int[] tri;
	static void find(int c) {
		for(int j=1;j<50;j++) {
			for(int k=1;k<50;k++) {
				for(int p=1;p<50;p++) {
					if(tri[j]+tri[k]+tri[p]==c) {
					flag=true;
					return;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		tri = new int[1001];
		check = new boolean[1001];
		for(int i=1;i<=1000;i++) {
			tri[i]= i*(i+1)/2;
		}
		for(int i=0;i<t;i++) {
			int input= sc.nextInt();
			find(input);
			if(flag) System.out.println(1);
			else System.out.println(0);
			flag=false;
		}
	}
	
}
