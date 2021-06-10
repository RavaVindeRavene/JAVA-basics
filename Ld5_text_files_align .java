
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Ld5_text_files_align {
//C:\Users\danie\Desktop\ld5\Text1.txt
    public static void main(String[] args)throws IOException {

        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileWriter("temp.txt"));
        String fileName="";
        System.out.print("\ninput file name:");
        fileName=sc.nextLine();
        sc.close();

        int rindas=0;
      
        FileReader fIn=new FileReader(fileName);
        BufferedReader br=new BufferedReader(fIn);
        String s;
        int rinda=0;
        int max=0;
        String vardiTemp[][]=new String[500][500];
        int varduSk[]=new int[500];
        int orgGarums[]=new int[500];
        while ((s = br.readLine()) != null) {
            if(s.length()>=max)max=s.length();
            String[]vardi=s.split("\\s+");
            varduSk[rinda]=vardi.length;
            orgGarums[rinda]=s.length();
            for(int i=0;i<=vardi.length-1;i++) {
                vardi[i].trim();
            vardiTemp[rinda][i]=vardi[i];
            }//ievade masiva
            rinda++;
            }//while beigas
        br.close();
        //max 41 4. 40

        for (int i=0;i<=rinda-1;i++) {
            int atstarpesKopa=max-orgGarums[i];//9
            if(varduSk[i]-1==0)continue;
            int atstarpe=atstarpesKopa/(varduSk[i]-1);//1.3
            int atlikums=atstarpesKopa%(varduSk[i]-1);
            int starpiba=atstarpesKopa-(atstarpe*(varduSk[i]-1));
            for(int j=0;j<=varduSk[i]-2;j++) {
                for(int k=0;k<=atstarpe;k++) {
                    vardiTemp[i][j]+=" ";
                }
                if(j==varduSk[i]-2&&starpiba!=0) {
                for(int l=0;l<=starpiba-1;l++)vardiTemp[i][l]+=" ";
                }
            }
        }//atstarpju ieliksana


        for(int i=0;i<=rinda;i++) {
            for(int j=0;j<=varduSk[i]-1;j++) {

               out.print(vardiTemp[i][j]);
            }
            out.println();
        }

        sc.close();
        out.close();

        File sourceFile = new File(fileName);
        File tempFile = new File("temp.txt");

        sourceFile.delete();
        tempFile.renameTo(sourceFile);

    }

}
