
/**
*
* @author Jolanta
*/
import java.util.Scanner;
public class point_location {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner (System.in);
	       float x, y;

	        System.out.print("x=");
	        if (sc.hasNextFloat())
	            x=sc.nextFloat();
	        else {
	            System.out.println("input-output error");
	            sc.close();
	            return;
	        }
	        System.out.print("y=");
	        if (sc.hasNextFloat())
	            y=sc.nextFloat();
	        else {
	            System.out.println("input-output error");
	            sc.close();
	            return;
	        }
	        sc.close();
	        
	        System.out.println("result:");
	        if (y>=8 && y<=9 && y<=6+x && y<=15-x){
	            System.out.println("blue");
	        } else
	             if ((x-2.5)*(x-2.5)+(y-7)*(y-7)<=0.25 && y<7 || (x-7.5)*(x-7.5)+(y-7)*(y-7)<=0.25 && y<7){
	             System.out.println("green");
	             
	             }else 
	                if ((x-2.5)*(x-2.5)+(y-7)*(y-7)<0.25 && y>=7|| (x-7.5)*(x-7.5)+(y-7)*(y-7)<0.25 && y>=7){
	                System.out.println("green");
	                 }else 
	                    if (x>=1 && x<=9 && y>=7 && y<=8){
	                    System.out.println("red");
	                    }else 
	                    System.out.println("white");
	    	 }
	    
	

	

}
