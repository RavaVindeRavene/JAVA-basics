
import java.util.Random;
import java.util.Scanner;

public class matrix_2_point_counting{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		int playercount=0, lowpointcount;
		String ch;
		int A [][]= {
				{250,300,250,250,250},
				{100,50,60,70,200},
				{250,100,70,150,200},
				{300,400,200,250,300},
				{400,320,250,220,270},
				{200,200,200,200,200},
				{250,260,250,250,250},
				{250,200,100,250,80}
				};
		System.out.print("Aizpildīt masīvu ar patvaļīgiem skaitļiem (y/n)?");
		Scanner sc=new Scanner(System.in);{
		if (sc.hasNext()) {ch=sc.next();}
		else {
			System.out.println("input-output error");
			sc.close();
			return;
			 }
		sc.close();
		}
	
	if (ch.equals("Y") || ch.equals("y"))
		{Random rnd=new Random();
		for (i=0;i<8; i++)
			for (j=0;j<5; j++)
				A[i][j]=rnd.nextInt(491)+10;
		}
	else if (!ch.equals("N") && !ch.equals("n")) {
		System.out.println("input-output error");
		return;
		}
	for (i=0;i<8;i++) {
		for (j=0;j<5;j++)
			System.out.printf(A[i][j]+"\t");
		System.out.println();}
	System.out.println("resut:");
	for (i=0;i<8;i++) {
		lowpointcount=0;
		for (j=0;j<5;j++) {
		if (A[i][j]<250) lowpointcount++;
		}
	if (lowpointcount!=0) playercount++;
	}
	System.out.println(playercount);
	}

}
