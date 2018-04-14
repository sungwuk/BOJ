import java.util.*;
public class _2563 {
	public static void main(String[] args) {
		int n,x,y,count=0,k;
		Scanner scan = new Scanner(System.in);
		n= scan.nextInt();k=n;
		boolean[][] check = new boolean [101][101];
		while(n>0) {
			x=scan.nextInt();y=scan.nextInt();
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					if(!check[i][j]) {
						check[i][j]=true;
						count++;
					}
				}
			}
		n--;
		}
		System.out.println(count);
	}
}
