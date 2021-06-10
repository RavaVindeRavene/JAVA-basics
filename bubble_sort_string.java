import java.util.Random;
import java.util.Scanner;

public class bubble_sort_string {
	
	public static void BubbleSort(char vect[]) {
		int k; char temp;
		int n=vect.length;
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (vect[j]<vect[j+1]) {
					temp=vect[j]; vect[j]=vect[j+1]; vect[j+1]=temp;}}}
		System.out.println();
		System.out.println("Sakārtotais vektors: ");
		for (int i=0;i<vect.length; i++) {System.out.print(vect[i]+" ");}	
	}//metodes beigas

	public static void SentinelSearch(char vect[], char elements, int n) {
		//meklēšana ar robežmarķieri
		int found=0; int pos=-1;
		
		for(int k=0; k<n && found!=1 ; k++) {
			if (elements==vect[k]) {pos=k; found=1; System.out.print(elements+" atrodas pozīcijā "+ pos);}
			if (pos==-1 && k==n-1) {System.out.println("Elements netika atrasts");}
		}	
	}//metodes beigas
	
	public static void main(String[] args) {
		// TODO Auto-generated method
		
			System.out.println();
			String rinda = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			char a[][]=new char [10][10];
			char vect[]=new char [55];
			char ch; int number;
			Random rnd=new Random();
			int count=rinda.length(); // 48, rinda length
			
			for (int i=0; i<10; i++) {
				for (int j=i; j<10; j++) {
					number=rnd.nextInt(count);ch=rinda.charAt(number);
					a[i][j]=ch; a[j][i]=ch;}}
			
			System.out.println("Simetriskā matrica: ");
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {System.out.print(a[i][j]+ " ");}
				System.out.println();}	
			System.out.println();
			
			System.out.println("Vektors:");
			int k=0;
					for (int j=0; j<10; j++) {
					for (int i=0; i<=j; i++) {vect[k]=a[i][j]; k++;} }
					
			for (int g=0; g<vect.length; g++)
			System.out.print(vect[g]+" ");
			
			System.out.println();
			System.out.println();
			System.out.println("Ievadiet simbolu, kas jāsameklē:");
			Scanner sc=new Scanner(System.in);
			char elements;
			String el="";
			if (sc.hasNext()) {el=sc.next();}
			if (el.length()==1 && el.charAt(0)>=65 && el.charAt(0)<=90 ||
				el.length()==1 && el.charAt(0)>=97 && el.charAt(0)<=122)
								{ elements=el.charAt(0);}
			else {System.out.println("input-output error");sc.close();return; }
			sc.close();
			
			SentinelSearch(vect,elements,vect.length);
			System.out.println();
			BubbleSort(vect);
			
			
			
			
	}//..

}
