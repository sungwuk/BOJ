import java.util.*;
public class _1100 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean chk[][]= new boolean[8][8];
		char map[][]= new char[8][8];
		for(int i=0;i<8;i++) {
			String in= sc.next();
			for(int j=0;j<8;j++) {
				map[i][j]=in.charAt(j);
				if(i%2==0&&j%2==0)chk[i][j]=true;
				else if((i+j)%2==0) chk[i][j]=true;
			}
		}
		int count=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(chk[i][j]&&map[i][j]=='F')count++;
			}
		}
		System.out.println(count);
	}

}
