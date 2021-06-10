
import java.util.Scanner;

public class Ld3_chars {
	
	public static void main(String[] args) {
	
Scanner sc=new Scanner(System.in);
System.out.println("input string:");
String text;
text=sc.nextLine();
text=text.trim();
sc.close();
int garums= text.length();
char[] arr=text.toCharArray();
int s=0;
int max=0;
char maxChar=arr[0];
for(int i=0;i<=garums-1;i++) {
	s=0;
	for(int j=i;j<=garums-1;j++) {
		if (arr[j]==arr[i])s++;
		if(j==garums-1 &&s>max) {
			max=s;
			maxChar=arr[i];
		}
	}
}
System.out.println("result:\n"+maxChar);
	}

}
