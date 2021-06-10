
import java.util.Scanner;
import java.util.Random;

public class matrix_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double A[]=new double [20];
		int K, i;
		
		Scanner sc=new Scanner (System.in);

		System.out.print("K=");
		
		if (sc.hasNextInt())
            K=sc.nextInt();
        else {
            System.out.print("input-output error");
            sc.close();
            return;}
            sc.close();
         
        //1.dala - masiva inicializacija ar while
        System.out.println("result:");
        
        if (K == 0) {
            Random r = new Random();
            i=0;
            while(i < 20) {
                A[i] = r.nextDouble()*30-10; 
            	i++	;
            }
            	}
        else  { //K<>0
        	A[0]=0.5; i=1;
        	while (i<20) {
        	A[i]=A[i-1]*K/3;
        	i++;}
        	}
        //2.dala - masiva izvade ar do while
        System.out.println("\nA:");

        i = 0;
        do  {
            System.out.printf("%.2f\t", A[i] );
            if (i == 9) 
                System.out.println();			
            i++;}
         while (i<20);
        //3.dala - masiva apstrade ar for
        for (i=0; i<20; i++)
        {
        	if (A[i]>10.0)
        		{int d=i+1;
        			for (i=19; i>d; i--)
        				A[i]=A[i-1];
        				A[d]=0;
        				break;}
        }
        //4.dala - masiiva izvade ar for 
        System.out.println("\nA:");
        for (i=0;i<20;i++)
        {
        	System.out.printf("%.2f\t",A[i]);
        	if (i==9) System.out.println();
        }

	}

}

