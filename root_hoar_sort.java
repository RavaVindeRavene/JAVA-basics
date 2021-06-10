
import java.util.Scanner;

public class root_hoar_sort {

	public static void firstMethod(int a[]) {
		//kvadrātsaknes izvēles metode
	if (a.length<2) return;
	int N=a.length;
	int gCnt=(int) Math.ceil(Math.sqrt(N));
	int gLen=(int) Math.floor(Math.sqrt(N));
	
	int buf[]=new int[gCnt];
	int gBorders[][]=new int[gCnt][2];
	
	gBorders[0][0]=0;
	gBorders[0][1]=gLen-1;
	
	for (int i=1;i<=gCnt-1;i++) { 
		gBorders[i][0]=gBorders[i-1][0]+gLen;
		gBorders[i][1]=gBorders[i-1][1]+gLen;}
	
	gBorders[gCnt-1][1]=N-1;
	
	for (int i=0; i<gCnt;i++) {
		int min=gBorders[i][0];
		for (int j=1+gBorders[i][0]; j<=gBorders[i][1];j++) {
			if (a[min]>a[j]) 
				min=j;}
			buf[i]=a[min];
			a[min]=Integer.MAX_VALUE;}
	
	int b[]=new int [N];
	
	for (int k=0;k<N;k++) {
		int bmin=gCnt-1;
		for (int i=0; i<gCnt;i++) {
			if (buf[i]<buf[bmin])
				bmin=i;}
		
		b[k]=buf[bmin];
		buf[bmin]=Integer.MAX_VALUE;
		int min=gBorders[bmin][0];
		for(int i=gBorders[bmin][0]+1; i<=gBorders[bmin][1];i++)
		{if (a[min]>a[i]) min=i;}
		buf[bmin]=a[min];
		a[min]=Integer.MAX_VALUE;
	}
	for (int g=0; g<N; g++) {
		a[g]=b[g];
		}
	} //metodes beigas
	
	public static void secondMethod(int a[]) {
		//hoara metode, un rekursiju izmantot ir aizliegts, QUICKSORT
	if (a.length<2) return;
	int left[] =new int [a.length/2];
	int right[] =new int [a.length/2];
	left[0]=0; right[0]=a.length-1; 
	int stackpos=1;
	int med,i,j,l,r, temp;
	while (stackpos>0) {
		stackpos=stackpos-1;
		l=left[stackpos];
		r=right[stackpos];
		
		while (l<r) {med=a[l+(r-l)/2];
					i=l;	j=r;
			
			while(i<=j) {
				while (a[i]<med) {i++;}
				while (a[j]>med) {j--;}
				if (i<=j) {
					temp=a[j]; a[j]=a[i]; a[i]=temp;
					i++; j--;
					}// if 
				}//while i<=j
			if (i<r) {
				left[stackpos]=i;
				right[stackpos]=r;
				stackpos+=1;
				}//if i<r
			r=j;
		}//while l<r
	} //while stackpos>0	
	}//metodes beigas
	
	public static void main(String[] args) {
		// TODO 

int meth, count;
System.out.print("method: "); 
Scanner sc=new Scanner (System.in);
	if (sc.hasNextInt()) meth=sc.nextInt();
	else {System.out.println("input-output error"); sc.close(); return;}
	if (meth!=1 && meth!=2) {System.out.println("input-output error"); sc.close(); return;}

System.out.print("count: "); 
	if (sc.hasNextInt()) count=sc.nextInt();
	else {System.out.println("input-output error"); sc.close(); return;}
	if (count==0) {System.out.println("input-output error"); sc.close(); return;}
int a[]=new int [count];
System.out.println("items:");
for (int i=0; i<count; i++) {
	if (sc.hasNextInt()) a[i]=sc.nextInt();
	else {System.out.println("input-output error"); sc.close(); return;}
	}
sc.close();	

System.out.println("result:");
if (meth==1) firstMethod(a);
else if (meth==2) secondMethod(a);
for (int h=0; h<count;h++) System.out.print(a[h]+" ");

	}
}
