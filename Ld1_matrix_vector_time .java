import java.util.Random;
public class Ld1_matrix_vector_time {
	
	public static void fillMatrix(int a[][]) {
		Random random = new Random();
        for(int j = 0; j < a.length; j++) {
                for(int i = a.length-1-j; i<a.length; i++) {
                	
                    if (i<0) return;     
                	a[i][j] = random.nextInt(201) - 100;
                }}
	}//metodes beigas
	
	public static void matrixToVector(int a[][], int b[]) {
		int vector[]=new int[a.length*(a.length+1)/2];
		int k=0;
		for(int j = 0; j < a.length; j++) {
            for(int i = a.length-j; i<a.length ; i++) {
                     vector[k++]=a[i][j];
            }} 
	}//metodes beigas
	
	
	public static void executeTask(int a[][], int vector[]) {
        long Time1, Time2, executionTimeMatrice, executionTimeVector;
        Time1 = System.nanoTime();
        int sum1 = 0;
        for(int j = 0; j < a.length; j++) {
            for(int  i = a.length-1-j; i<a.length; i++) {
                        if (a[i][j]%2==0 && a[i][j]!=0 ){sum1++;}        
                        }}
        Time2 = System.nanoTime();
        executionTimeMatrice = (Time2-Time1);
        Time1 = System.nanoTime();
        int sum2 = 0;
        for(int i = 0; i < vector.length; i++) {
                if(vector[i]%2==0 && vector[i]!=0) { sum2++;}
        }
        Time2 = System.nanoTime();
        executionTimeVector = (Time2-Time1);
        System.out.printf("|| %3dx%3d\t|| %5d\t|| %14d\t|| %14d\t|| %5d\t||\n",
        		a.length,a.length, sum1, executionTimeMatrice, executionTimeVector, 
        		Math.abs(executionTimeMatrice-executionTimeVector));
}//metodes beigas
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

int[][] a,b,c;
a = new int[5][5];
b = new int[100][100];
c = new int[500][500];

fillMatrix(a);
fillMatrix(b);
fillMatrix(c);
 for(int i = 0; i < a.length; i++) {
for(int j = 0; j < a.length; j++) {
    System.out.print(a[i][j]+"\t");
}	System.out.println();}



int[] av =new int [16];
int [] bv=new int [5050];
int []cv=new int [125250];
matrixToVector(a,av);
matrixToVector(b,bv);
matrixToVector(c,cv);
	


System.out.println("==================================================================================================");
System.out.println("|| Izmers\t|| Rezultats\t|| Laiks Matricai\t|| Laiks Vektoram\t|| Starpiba\t||");
System.out.println("==================================================================================================");
executeTask(a,av);
executeTask(b,bv);
executeTask(c,cv);
	
	}

}
