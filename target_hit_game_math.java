
/**
*
* @author Jolanta
*/

import java.util.Scanner;
public class target_hit_game_math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		double t, x, y, v0, g, a;
		boolean hitTarget=false;
		
		System.out.print("Leņķis a= ");
        if (sc.hasNextDouble())
            a=sc.nextDouble();
        else {
            System.out.println("input-output error");
            sc.close();
            return;}
            sc.close();
        t=0.05;
        g=11.09;
        v0=15;
        System.out.println("result:");
        System.out.println(" t \t  x \t  y");
        
        do 
        {
        	x=v0*t*Math.cos(Math.toRadians(a));
        	y=v0*t*Math.sin(Math.toRadians(a))-g*t*t/2;
        	System.out.printf("%3.2f\t%7.3f\t %7.3f\n", t, x, y);
        	
        	if (x >= 17 && x <= 20 && y <= 3) {
        		hitTarget = true;}
     
        	t+=0.05;
        }
        while ((x<7 && y>=0) || (x>=7 && x<10 && y>=4) || 
        		(x>=10 && x<17 && y>=0) || (x>=17 && x<=20 && y>=3) || (x>20 && y>=0));
        
        if (hitTarget) {
            System.out.println("the target was destroyed");
        } else {
            System.out.println("shot off the target");}
	}

}
