import java.util.*;
public class _1213 {
static boolean isPal(char[] in) {
	if(in.length%2==0) {
		for(int i=0;i<in.length;i++) {
				if(in[i]!=in[in.length-1-i]) return false;
		}
		return true;
	}
	else {
		for(int i=0;i<in.length;i++) {
			if(in[i]!=in[in.length-1-i]) return false;
	}
		return true;
	}
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input=sc.next();
		int chk[] = new int[26];	//A =65
		char []tmp = new char[input.length()];
		LinkedList<Character> list_1 = new LinkedList<>();
		LinkedList<Character> list_2 = new LinkedList<>();
		char []result = new char[tmp.length];
		tmp=input.toCharArray();
		Arrays.sort(tmp);
		if(input.length()%2==0) {			//input 스트링의 길이가 짝수인경우
			for(int i=0;i<tmp.length;i++) {
				if(i%2==0) {
					list_1.add(tmp[i]);
				}
				else list_2.add(tmp[i]);
			}
			for(int i=0;i<tmp.length/2;i++) {
				char a = list_1.poll();
				char b = list_2.poll();
				result[i]=a;
				result[tmp.length-1-i]=b;
			}
		}
		else {
			for(int i=0;i<tmp.length;i++) {		//가운데 들어갈 문자를 찾기위해
				chk[tmp[i]-65]++;
			}
			char center=' ';
			for(int i=0;i<26;i++) {
				if(chk[i]%2!=0) center= (char)(i+65);
			}
			boolean flag=true;
			for(int i=0;i<tmp.length;i++) {
				if(tmp[i]==center&&chk[tmp[i]-65]==1) { 
					continue;
				}
				if(tmp[i]==center&&chk[tmp[i]-65]%2!=0&&flag) {
					flag = false;
					continue;
				}
				if(i%2==0) {
					list_1.add(tmp[i]);
				}
				else list_2.add(tmp[i]);
			}
			for(int i=0;i<tmp.length/2;i++) {
				char a = list_1.poll();
				char b = list_2.poll();
				result[i]=a;
				result[tmp.length-1-i]=b;
			}
			result[tmp.length/2]=center;
		}
		if(isPal(result)) {
			System.out.println(new String(result));
		}
		else System.out.println("I'm Sorry Hansoo");

	}
}
