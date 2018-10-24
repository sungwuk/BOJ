import java.util.*;
public class _5622 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String in = sc.next();
		int count=0;
		for(int i=0;i<in.length();i++) {
			char tmp =in.charAt(i);
			if(tmp=='A'||tmp=='B'||tmp=='C') {
				count+=3;
			}
			else if(tmp=='D'||tmp=='E'||tmp=='F') {
				count+=4;
			}
			else if(tmp=='G'||tmp=='H'||tmp=='I') {
				count+=5;
			}
			else if(tmp=='J'||tmp=='K'||tmp=='L') {
				count+=6;
			}
			else if(tmp=='M'||tmp=='N'||tmp=='O') {
				count+=7;
			}
			else if(tmp=='P'||tmp=='Q'||tmp=='R'||tmp=='S') {
				count+=8;
			}
			else if(tmp=='T'||tmp=='U'||tmp=='V') {
				count+=9;
			}
			else if(tmp=='W'||tmp=='X'||tmp=='Y'||tmp=='Z') {
				count+=10;
			}
		}
		System.out.println(count);
	}

}
