import java.util.*;
public class _14499 {
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	static int map[][],cx,cy,n,m,x,y,k,nx,ny;
	static LinkedList<Integer> dice_row= new LinkedList<Integer>();			//주사위 전개도 가로
	static LinkedList<Integer> dice_column= new LinkedList<Integer>();		//주사위 전개도 세로
	static void roll(int d) {						// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
		if(d==1||d==2) {							// 동 서
			if(d==1) {
				ny = cy+1;
				if(ny>=m) return;
				cy=ny;
				int tmp1 = dice_row.pollLast();
				int tmp2 = dice_column.pollLast();
				dice_row.addFirst(tmp2);
				dice_column.addLast(tmp1);
				int pop = dice_column.pollFirst();
				dice_column.pollFirst();
				dice_column.addFirst(dice_row.get(1));
				dice_column.addFirst(pop);
			}
			if(d==2) {
				ny = cy-1;
				if(ny<0) return;
				cy =ny;
				int tmp1 = dice_row.pollFirst();
				int tmp2 = dice_column.pollLast();
				dice_row.addLast(tmp2);
				dice_column.addLast(tmp1);
				int pop = dice_column.pollFirst();
				dice_column.pollFirst();
				dice_column.addFirst(dice_row.get(1));
				dice_column.addFirst(pop);
			}
			if(map[cx][ny]==0) {					
				map[cx][ny]= dice_column.get(3);	
			}
			else {									
				dice_column.removeLast();		
				dice_column.add(map[cx][ny]);
				map[cx][cy]=0;
			}
		}
		if(d==3||d==4) {
			if(d==3) {
				nx = cx-1;
				if(nx<0) return;					
				cx=nx;
				int tmp = dice_column.pollFirst();			
				dice_column.addLast(tmp);
				int pop = dice_row.pollLast();
				dice_row.pollLast();
				dice_row.add(dice_column.get(1));
				dice_row.add(pop);	
			}
			if(d==4) {							//남 북
				nx = cx+1;
				if(nx>=n) return;					//맵 바깥으로 벗어난 경우 명령 무시
				cx=nx;
				int tmp = dice_column.pollLast();			//주사위를 아래로 굴린다
				dice_column.addFirst(tmp);
				int pop = dice_row.pollLast();
				dice_row.pollLast();
				dice_row.add(dice_column.get(1));
				dice_row.add(pop);
			}
			if(map[nx][cy]==0) {					//굴려진 후, 0이면 주사위 바닥에 있는 수가 칸에 복사.
				map[nx][cy]= dice_column.get(3);	//바닥에 있는 수 칸에 복사.
			}
			else {									//굴려진 후, 바닥에 있는 수가 0이 아닌경우 칸에 있는 수가 자사위 바닥으로 복사
				dice_column.removeLast();			//바닥에 있는 수가 주사위로 복사됨
				dice_column.add(map[nx][cy]);
				map[nx][cy]=0;
			}
		}
		System.out.println(dice_column.get(1));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();m=sc.nextInt();x=sc.nextInt();y=sc.nextInt();k=sc.nextInt();
		map= new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<4;i++) dice_column.add(0);
		for(int i=0;i<3;i++) dice_row.add(0);
		cx=x;cy=y;
		for(int i=0;i<k;i++) {
			int e = sc.nextInt();
			roll(e);
		}
	}
}