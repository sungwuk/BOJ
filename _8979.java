import java.util.*;
public class _8979 {
	static class Contry implements Comparable<Contry>{
		int number;
		int gold;
		int siver;
		int bronze;
		int rank;
		
		public Contry(int number,int gold,int siver,int bronze) {
			this.number=number;
			this.gold=gold;
			this.siver=siver;
			this.bronze=bronze;
			this.rank=1;
		}
		@Override
		public int compareTo(Contry o) {
			// TODO Auto-generated method stub
			if(this.gold>o.gold) return 1;
			else if(this.gold<o.gold) return -1;
			else {
				if(this.siver>o.siver) return 1;
				else if(this.siver<o.siver) return -1;
				else {
					return this.bronze-o.bronze;
				}
			}
		}
	}
	public static void main(String[] args) {
		int N,K;
		Scanner scan= new Scanner(System.in);
		N = scan.nextInt();K=scan.nextInt();
		Contry[] contries = new Contry[N] ;
		for(int i=0;i<N;i++) {
			int num = scan.nextInt();
			int gold=scan.nextInt();
			int siver =scan.nextInt();
			int bronze = scan.nextInt();
				contries[i]= new Contry(num,gold, siver, bronze);
		}
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(contries[i].compareTo(contries[j])>0) {				//i번째가 j번째보다 순위가 높은경우
					contries[j].rank++;
				}
				else if(contries[i].compareTo(contries[j])==0) {
					continue;
				}
				else {												    //j번째 나라가 i번째보다 높은경우
					contries[i].rank++;
				}
			}
		}
		for(Contry c : contries) {
			if(c.number==K) System.out.println(c.rank);
		}
	}
}
