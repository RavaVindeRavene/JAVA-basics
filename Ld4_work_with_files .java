
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Ld4_work_with_files {

	public static void main(String[] args) throws IOException{
	
		Scanner sc=new Scanner(System.in);
		String fileName="";
		System.out.print("\ninput file name:");
		fileName=sc.nextLine();
		sc.close();

		int rindas=0;
		String varditemp[][]=new String[500][7];
		FileReader fIn=new FileReader(fileName);
		BufferedReader br=new BufferedReader(fIn);
		String s;
		while ((s = br.readLine()) != null) {
			rindas++;
			String[]vardi=s.split("\\s+");
			for (int i=0;i<=6;i++) {
				varditemp[rindas-1][i]=vardi[i];
				          }
			}//while beigas
br.close();
System.out.println("result:");

for (int i=0;i<=rindas-1;i++) {
	int nesekmigas=0;
	for(int j=2;j<=6;j++) {
		int atzime=Integer.parseInt(varditemp[i][j]);
		if (atzime<4) {
			nesekmigas++;
		}	
		}
		if (nesekmigas>0)System.out.println(varditemp[i][1]+" "+varditemp[i][0]+" "+nesekmigas);
		
	
}
}
}