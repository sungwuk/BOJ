import java.util.*;
public class _10798 {
	public static void main(String[] args) {
		String[] input = new String[10];
		Scanner scan = new Scanner(System.in);
		int N=5,i=0,sum=0,max;
		input[i] = scan.next();
		max=input[i].length();
		i++;
		while(N>1) {
			input[i] = scan.next();
			sum+=input[i].length();
			if(max<input[i].length()) max=input[i].length();
			i++;
			N--;
		}
		for(int j=0;j<max;j++) {	
			for(int k=0;k<5;k++) {
				while(input[k].length()<=j) {
					k++;
					if(k>=5) {
						break;
					}
				}
				if(k<5) System.out.print(input[k].charAt(j));
			}
		}
	}
}