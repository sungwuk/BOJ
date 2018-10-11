import java.util.Scanner;
import java.io.FileInputStream;

public class _14891{
	static int arr[][] = new int[4][8];
	static boolean chk[]= new boolean[4];
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<4;i++) {
			String s = sc.next();
			for(int j=0;j<8;j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		int k=sc.nextInt();
		for(int i=0;i<k;i++) {
			int num = sc.nextInt()-1;
			int order = sc.nextInt();
			if(order==1) clock(num);
			else counter(num);
			chk= new boolean[4];
		}
		int sum=0;
		for(int i=0;i<4;i++) {
			sum=(int) (sum+arr[i][0]*(Math.pow(2, i)));
		}
		System.out.println(sum);
	}
	static void clock(int num) {
		if(num<0||num>3||chk[num]) return;
		chk[num]=true;
		boolean left = false,right=false;
		if(num>0&&arr[num][6]!=arr[num-1][2]) left=true;
		if(num<3&&arr[num][2]!=arr[num+1][6]) right=true;
		
		int tmp = arr[num][7];
		System.arraycopy(arr[num], 0, arr[num], 1, 7);
		arr[num][0]=tmp;
		if(right) counter(num+1);
		if(left) counter(num-1);
	}
	static void counter(int num) {
		if(num<0||num>3||chk[num]) return;
		chk[num]=true;
		boolean left = false,right=false;
		if(num>0&&arr[num][6]!=arr[num-1][2]) left=true;
		if(num<3&&arr[num][2]!=arr[num+1][6]) right=true;
		int tmp = arr[num][0];
		System.arraycopy(arr[num], 1, arr[num], 0, 7);
		arr[num][7]=tmp;
		if(right) clock(num+1);
		if(left) clock(num-1);
	}
}