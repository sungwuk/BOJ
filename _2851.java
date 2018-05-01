import java.util.*;
public class _2851 {
	public static void main(String[] args) {
		int score,sum=0;
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			score=scan.nextInt();
			sum+=score;
			if(sum>100) {
				int a= Math.abs(sum-100);
				int b= Math.abs(sum-score-100);
				sum=(a>b) ? sum-score:sum;
				break;
			}
		}
		System.out.println(sum);
	}
}