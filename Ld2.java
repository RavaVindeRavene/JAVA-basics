
import java.util.Scanner;
public class Ld2 {
	public static int maina;
	public static void ievade(int[]a,int count) {
		Scanner sc=new Scanner(System.in);
		if (count==0) return; else { 
		a[count-1]=sc.nextInt();
		count--;
		ievade(a,count);
		}
	}
	public static void apstrade(int[]a,int count) {
		
		if (count==1)return;else {
			if (a[count-1]>=0 && a[count-2]<0||a[count-1]<0 && a[count-2]>=0) {
				maina++;
			}
			count--;
			apstrade(a,count);
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.out.println("count:");
Scanner sc=new Scanner(System.in);
int count;
if (sc.hasNextInt())count=sc.nextInt();
else {System.out.println("Input-output error"); return;}
int a[]=new int[count];
System.out.println("numbers:");
ievade(a,count);
apstrade(a,count);
System.out.println("result:\n"+maina);


		
	}

}
