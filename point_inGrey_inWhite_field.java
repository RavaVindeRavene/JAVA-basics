
import java.util.Scanner;
public class point_inGrey_inWhite_field {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
	double x=0, y=0;
	System.out.print("x=");	
	x=sc.nextDouble();
	System.out.print("y=");
		y=sc.nextDouble();
		sc.close();
		
	if(x<5 && y<3+x && y>4 || (x-7)*(x-7) + (y-3)*(y-3)<=4)
		System.out.println("result:\ngrey");
	else
		System.out.println("result:\nwhite");
	}

}
