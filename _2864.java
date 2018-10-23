import java.util.*;
public class _2864 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a =sc.next(),b=sc.next();
		char[] arrA = a.toCharArray();
		char[] arrB = b.toCharArray();
		for(int i=0;i<arrA.length;i++) {
			if(arrA[i]=='6') arrA[i]='5';
		}
		for(int i=0;i<arrB.length;i++) {
			if(arrB[i]=='6') arrB[i]='5';
		}
		String na = new String(arrA);
		String nb = new String(arrB);
		int min = Integer.valueOf(na)+Integer.valueOf(nb);
		System.out.print(min+" ");
		for(int i=0;i<arrA.length;i++) {
			if(arrA[i]=='5') arrA[i]='6';
		}
		for(int i=0;i<arrB.length;i++) {
			if(arrB[i]=='5') arrB[i]='6';
		}
		na = new String(arrA);
		nb = new String(arrB);
		min = Integer.valueOf(na)+Integer.valueOf(nb);
		System.out.println(min);
	}
}