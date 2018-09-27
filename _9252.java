import java.util.*;
public class _9252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a=sc.next(),b=sc.next();
		int dp[][]= new int[a.length()+1][b.length()+1];
		
		for(int i=1;i<=a.length();i++) {
			for(int j=1;j<=b.length();j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		Stack<Integer> list = new Stack<>();
		int index1 = a.length(),index2=b.length();
		while(index1!=0&&index2!=0) {
			if(a.charAt(index1-1)==b.charAt(index2-1)) {
				list.push(index1);
				index1--;
				index2--;
			}
			else if(dp[index1][index2]==dp[index1-1][index2])index1--;
			
			else if(dp[index1][index2]==dp[index1][index2-1]) index2--;
		}
		System.out.println(dp[a.length()][b.length()]);
		while(!list.isEmpty()) System.out.print(a.charAt(list.pop()-1));
	}
}