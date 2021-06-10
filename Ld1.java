

import java.util.Scanner;

public class Ld1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.out.println("uzdevums:");
int a, i,j;
a=0;
int m[][]=new int[10][10];
Scanner sc=new Scanner(System.in);
if (sc.hasNextInt()) a=sc.nextInt();
if (a!=1 && a!=2) { 
	System.out.println("result:\ninput-output error");
	sc.close();
	return;
}
System.out.println("result:");
if (a==1) { 
	int n=1;
	for (i=0;i<=9;i++) {
		for (j=9-i;j<=9-i+2;j++) {
			if(j<=9)m[i][j]=n++;
		}
	}
	for(i=0;i<=9;i++) {
		for(j=0;j<=9;j++) {
			System.out.print(m[i][j]+"\t");
		}
		System.out.println();
	}
}//1 variants
if (a==2) { 
	for (i=0;i<=9;i++) {
		int n=9;
		for (j=1+i;j<=9;j++) {
			m[i][j]=n--;
		}
	}
	for(i=0;i<=9;i++) {
		for(j=0;j<=9;j++) {
			System.out.print(m[i][j]+"\t");
		}
		System.out.println();
	}
}//2 variants


	}
}
