
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

//================================================

class Student implements Serializable{
	public String name;
	public String surname;
	public int mark1, mark2, mark3;
	
	public Student(String name, String surname, int mark1, int mark2, int mark3) {
		this.name = name;
		this.surname = surname;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}
	
	public void print(int numurs) {
		System.out.printf("\n%-4d%-15s%-15s%-12d%-12d%-12d", numurs, name, surname, mark1, mark2, mark3);
	}
}

//================================================

public class Ld7_objects {

	static Scanner sc = new Scanner(System.in);
	
	static String filename = "Students.dat";

	public static void main(String[] args) {
		int choise;
		String choiseStr;

		loop: while (true) {

			System.out.println("\n1) Create");
			System.out.println("2) Calculate");
			System.out.println("3) View");
			System.out.println("4) About");
			System.out.println("5) Exit");
			System.out.print("\nInput number from 1 till 5: ");
			
			choiseStr = sc.nextLine();
			
			try {
				choise = Integer.parseInt(choiseStr);
				if (choise < 1 || choise > 5) {
					throw new Exception();
				}
			}
			catch (Exception ex) {
				System.out.println("Error, please, input number from 1 till 5");
				continue;
			}
			

			switch (choise) {
			case 1:
				create();
				break;
			case 2:
				calculate();
				break;
			case 3:
				view();
				break;
			case 4:
				about();
				break;
			case 5:
				break loop;
			}
		}

		sc.close();
	}

	public static void create() {
		Student student;
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			
			student = new Student("Andris", "Liepiņš", 5, 4, 3);
			out.writeObject(student);
			
			student = new Student("Maris", "Riekstiņš", 9, 9, 9);
			out.writeObject(student);
			
			student = new Student("Pēteris", "Ozols", 8, 7, 8);
			out.writeObject(student);
			
			student = new Student("Mara", "Liepa", 4, 2, 9);
			out.writeObject(student);
			
			student = new Student("Inga", "Kļaviņa", 7, 7, 7);
			out.writeObject(student);
			
			out.close();
			
			System.out.println("\nFile " + filename + " succesfully created");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}	
	}

	public static void calculate() {
		// TODO develop this method
		int numurs = 1;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp.dat"));
			Student s;
		    boolean EOF = false;
		    
		    while (!EOF) {
		        try {
		            s = (Student) in.readObject();
		            if (s.mark1>=4 && s.mark2>=4 && s.mark3>=4)out.writeObject(s);
		            
		        } 
		        catch (EOFException e) {
		            EOF = true;
		        }
		    }
		    
		    in.close();  	
		    out.close();
		    File sourceFile=new File(filename);
			File tempFile=new File("temp.dat");
			
			 sourceFile.delete();
		        tempFile.renameTo(sourceFile);
		         
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}

	public static void view() {
		File f = new File (filename);
		if (!f.exists()) {
			System.out.println("Faila " + filename + " nav, lūdzu sākumā izpildiet komandu \"Create\"");
			return;
		}
		
		System.out.println("\n-----------------------------------------------------------------------");
		System.out.printf("#   %-15s%-15s%-12s%-12s%-12s", "Vārds", "Uzvārds", "Matemātika", "Fizika", "Programmēšana");
		System.out.print("\n-----------------------------------------------------------------------");
		
		int numurs = 1;
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			
			Student s;
		    boolean EOF = false;
		    
		    while (!EOF) {
		        try {
		            s = (Student) in.readObject();
		            s.print(numurs++);
		        } 
		        catch (EOFException e) {
		            EOF = true;
		        }
		    }
		    
		    in.close();  	
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\n-----------------------------------------------------------------------");
	}

	public static void about() {
		// TODO insert information about authors
		System.out.println("\n4. variants");
		
	}
}

//================================================