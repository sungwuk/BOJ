import java.util.*;
public class _1076 {
	static class elec{
		String color;
		long val,mul;
		elec(String s,long v,long m){
			this.color=s;this.val=v;this.mul=m;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		elec tmp[] = new elec[10];
		for(int i=0;i<10;i++)tmp[i]= new elec(null, 0, 0);
		tmp[0]= new elec("black", 0, 1);
		tmp[1]= new elec("brown", 1, 10);
		tmp[2]= new elec("red", 2, 100);
		tmp[3]= new elec("orange", 3, 1000);
		tmp[4]= new elec("yellow", 4, 10000);
		tmp[5]= new elec("green", 5, 100000);
		tmp[6]= new elec("blue", 6, 1000000);
		tmp[7]= new elec("violet", 7, 10000000);
		tmp[8]= new elec("grey", 8, 100000000);
		tmp[9]= new elec("white", 9, 1000000000);
		String v1 = sc.next(),v2=sc.next(),v3=sc.next();
		String a="",b="";
		long k=0;
		for(int i=0;i<10;i++) {
			if(tmp[i].color.equals(v1)) a= String.valueOf(tmp[i].val);
			if(tmp[i].color.equals(v2)) b= String.valueOf(tmp[i].val);
			if(tmp[i].color.equals(v3)) k = tmp[i].mul;
		}
		a=a.concat(b);
		long tm = Long.parseLong(a);
		System.out.println(tm*k);
	}
}