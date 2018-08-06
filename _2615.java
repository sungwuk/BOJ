import java.util.*;
public class _2615 {
	static int map[][] = new int[22][22];
	static boolean find_1(int x,int y, int count) {
		int cur = map[x][y];
		for(;cur==map[x][y+1];y+=1) {
			count++;
		}
		return count ==5 ? true:false;
	}
	static boolean find_2(int x,int y, int count) {
		int cur = map[x][y];
		for(;cur==map[x+1][y+1];x+=1,y+=1) {
			count++;
		}
		return count ==5 ? true:false;
	}
	static boolean find_3(int x,int y, int count) {
		int cur = map[x][y];
		for(;cur==map[x+1][y];x+=1) {
			count++;
		}
		return count ==5 ? true:false;
	}
	static boolean find_4(int x,int y, int count) {
		int cur = map[x][y];
		for(;cur==map[x-1][y+1];x-=1,y+=1) {
			count++;
		}
		return count ==5 ? true:false;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=19;i++) {
			for(int j=1;j<=19;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=1;i<=19;i++) {
			for(int j=1;j<=19;j++) {
				if(map[i][j]!=0) {			//돌이 있는곳을 시작으로 해야한다.
					if(map[i][j-1]!=map[i][j]&&find_1(i,j,1)) {			//    ->
						System.out.println(map[i][j]);
						System.out.println(i+" "+j);
						return;
					}
					if(map[i-1][j-1]!=map[i][j]&&find_2(i,j,1)) {		//감소 대각선
						System.out.println(map[i][j]);
						System.out.println(i+" "+j);
						return;
					}
					if(map[i-1][j]!=map[i][j]&&find_3(i,j,1)) {			//    아래
						System.out.println(map[i][j]);
						System.out.println(i+" "+j);
						return;
					}
					if(map[i+1][j-1]!=map[i][j]&&find_4(i,j,1)) {
						System.out.println(map[i][j]);
						System.out.println(i+" "+j);
						return;
					}
				}
				
			}
		}
		System.out.println(0);
		return;
	}

}
