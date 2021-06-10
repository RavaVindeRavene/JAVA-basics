package dip107;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import java.util.Collections;
import java.util.Comparator;




class Gramata implements Serializable{
    public String authorName;
    public String authorSurname;
    public String bookName;
    public String readerID;
    public String returnDate;
    public String bookStatus;
    public Gramata (String authorSurname, String authorName,String bookName, String bookStatus, 
    		String readerID, String returnDate) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.bookName= bookName;
        this.bookStatus=bookStatus;
        this.readerID= readerID;
        this.returnDate=returnDate;
        
      
    }
    public void print(int numurs) {
        System.out.printf("\n%-4d%-15s%-15s%-15s%-15s%-15s%-15s", numurs, 
        		authorSurname, authorName, bookName, bookStatus, readerID, returnDate);
    }
    public void changeInfo(String authorSurname, String authorName,String bookName, String bookStatus, 
    		String readerID, String returnDate) {
    	this.authorSurname=authorSurname;
    	this.authorName=authorName;
    	this.bookName=bookName;
    	this.bookStatus=bookStatus;
    	this.readerID=readerID;
    	this.returnDate=returnDate;	
    }
}


public class Md2_library{
	static Scanner sc = new Scanner(System.in);
	   
    static String filename = "bibliotekasinfo.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice=0;
        loop: while (true) {

            System.out.println("\n1) Izveidot failu ar gramatu sarakstu"); //create
            System.out.println("2) apskatīt sarakstu"); //view
            System.out.println("3) pievienot grāmatu sarakstam "); //add
            System.out.println("4) izdzēst grāmatu no saraksta"); //delete
            System.out.println("5) editēt grāmatas informāciju"); // edit
            System.out.println("6) sakārtot grāmatas pēc autora vai nosaukuma"); //sort
            System.out.println("7) sameklēt grāmatas pēc autora uzvērda"); // search
            System.out.println("8) aprēķināt cik grāmatas ir plauktā un cik izsniegtas");//calculate
            System.out.println("9) informācija par autori");//about
            System.out.println("10) beigt darbu");
            
            
           
            System.out.print("\nIevadiet skaitli no 1 līdz 10: ");
           
            choice = sc.nextInt();
           
            try {
                  if (choice < 1 || choice > 10) {
                    throw new Exception();
                }
            }
            catch (Exception ex) {
                System.out.println("Ievades kļūda! Ievadiet skaitli no 1 līdz 9:");
                continue;
            }
            switch (choice) {
            case 1:
                create(); break;
            case 2:
                view(); break;
            case 3:
                add();break;
            case 4:
                delete();break;
            case 5:
            	edit(); break;
            case 6:
            	sort(); break;
            case 7:
            	search(); break;
            case 8:
            	calculate(); break;
            case 9:
            	about(); break;
            case 10: break loop;
            default:
				System.out.println("\nKļūda! \n");
				break;
            }
        }
        sc.close();
    }
	public static void create() {
        Gramata gr;
       
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
           
            gr = new Gramata("Shakespeare", "William", "Macbeth","plauktā", "--", "--");
            out.writeObject(gr);
           
            gr = new Gramata("King", "Stephen", "It","plauktā","--","--");
            out.writeObject(gr);
            
            gr = new Gramata("King", "Stephen", "Ghost","izsniegta","lasitajs1","30.5.2019");
            out.writeObject(gr);
            
            gr = new Gramata("Mayer", "Stephanie", "Host","plauktā","--","--");
            out.writeObject(gr);
            
            gr = new Gramata("Rainis", "Jānis", "Zelta zirgs","plauktā","--","--");
            out.writeObject(gr);
            
            out.close();
           
            System.out.println("\nFile " + filename + " succesfully created");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }   
    }
	public	static void sort() {
		System.out.println ("Sakārtot grāmatas pēc autoru uzvārdiem (1) vai grāmatu nosaukumiem (2)");
		int izvele;
		if (sc.hasNextInt())izvele=sc.nextInt();
		else return;
		File f = new File (filename);
        if (!f.exists()) {
            System.out.println("Faila " + filename + " nav");
            return;}
        
        
    		 Vector <Gramata> booklist =new Vector<Gramata>();
    			try { 
    				ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename));
    				
    				Gramata gr;
    				boolean EOF=false;
    				while (!EOF) {
    					try {
    						gr = (Gramata) in.readObject();
    						booklist.add(gr);   
    					}
    					catch (EOFException e) {EOF=true;}
    				}
    				in.close();	
    			}
    			catch (Exception ex) {
    				System.out.println(ex.getMessage());
    			}
    			
    			
    			switch (izvele) {
    		
    			//pēc uzvarda
    			case 1:
    				System.out.println("");
    				Collections.sort(booklist, new Comparator<Gramata>()
    				{
    				@Override
    				public int compare(Gramata o1, Gramata o2) {
    						return o1.authorSurname.compareTo(o2.authorSurname);
    				}
    				});
    				break;
    				
    				//pēc nosaukuma
    			case 2:
    				System.out.println("");
    				Collections.sort(booklist, new Comparator<Gramata>()
    				{
    					@Override
    					public int compare(Gramata o1, Gramata o2) {
    							return o1.bookName.compareTo(o2.bookName);
    							}
    				});
    				break;

    			default:
    				System.out.println("\nKļūda! \n");
    				break;
    			}
    			 try {
    		            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
    		           
    		            for(Gramata car : booklist) {
    		                out.writeObject(car);
    		            }
    		            out.close();
    		            System.out.println("Faila " + filename + "informācija tika pārkārtota.");
    		            view();
    		        }
    		        catch (Exception ex) {
    		            System.out.println(ex.getMessage());
    		        }   
    		    }
    		    
		
	
	public static void search() {
		File f = new File (filename);
        if (!f.exists()) {
            System.out.println("Faila " + filename + " nav");
            return;
        }

        int numurs = 1;
        String searchSurname;
       Scanner sc=new Scanner (System.in);
        if (sc.hasNext()) searchSurname=sc.nextLine();
        else {return; }
        
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.printf("#   %-15s%-15s%-15s%-15s%-15s%-15s", "Uzvārds", "Vārds", "Nosaukums", "Statuss", "Lasītāja ID", "Nodošanas datums");
        System.out.print("\n-----------------------------------------------------------------------");
       
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
           
            Gramata G;
            boolean EOF = false;
           
            while (!EOF) {
                try {
                    G = (Gramata) in.readObject();
                    if (G.authorSurname.equals(searchSurname)) 
                    		G.print(numurs++);
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
	}
	
	public static void calculate() {
		File f = new File (filename);
        if (!f.exists()) {
            System.out.println("Faila " + filename + " nav");
            return;
        }
        
        int izsniegtasGramatas=0;
        int plauktaGramatas=0;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
           
            Gramata G;
            boolean EOF = false;
           
            while (!EOF) {
                try {
                    G = (Gramata) in.readObject();
                    if (G.readerID.equals("--")) {plauktaGramatas++;}
                    else izsniegtasGramatas++;
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
        System.out.println("Izsniegto grāmatu daudzums:" + izsniegtasGramatas);
        System.out.println("Grāmatu skaits uz vietas: "+ plauktaGramatas);
		
	}
	
	public static void about() {
        // TODO insert information about authors
        System.out.println("\n8. variants");
      
    }	

	public static void add() {
		int numurs=0;
		int secigi=1;
		String newID="--";
		String newDate="--";	
		
		
		
		File f = new File (filename);
        if (!f.exists()) {
            System.out.println("Faila " + filename + " nav");
            return;}
				        try {
							ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
							ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp.dat"));
							Gramata G;
						    boolean EOF = false;
						    
						    while (!EOF) {
						        try { 
						        	if (numurs==0) {System.out.println("Jaunās grāmatas informācija:");
									System.out.println("Ievadiet grāmatas autora vārdu");
									
									String newName=sc.nextLine();
									
									System.out.println("Ievadiet grāmatas autora uzvārdu");
									String newSurname=sc.nextLine();
									System.out.println("Ievadiet grāmatas nosaukumu");
									String newBook=sc.nextLine();
									System.out.println("Ievadiet grāmatas statusu  (izsniegta/plauktā)");
									String newStatus=sc.nextLine();
									if (newStatus.equals("izsniegta")) {
										System.out.println("Ievadiet lasītāja ID");
										 newID=sc.nextLine();
										System.out.println("Ievadiet atdošanas datumu (dd.mm.gggg)");
										 newDate=sc.nextLine();
							    			}
									Gramata nbook= new Gramata(newSurname, newName, newBook,newStatus, newID, newDate);
									out.writeObject(nbook);	
						        	}
						        	G = (Gramata) in.readObject(); numurs++;
						        	out.writeObject(G);
						        	} 
						        catch (EOFException e) { EOF = true;}
						    		}
						    in.close();  	
							out.close();
							File sourceFile=new File(filename);
							File tempFile=new File("temp.dat");
							sourceFile.delete();
							tempFile.renameTo(sourceFile);       
							}
							catch (Exception ex) {System.out.println(ex.getMessage());}
		
		
				
	}
	
	public static void delete() {
		int numurs = 1;
		System.out.println("Ievadiet grāmatas numuru, kuru vēlaties izdzēst:");
		int deleteNumber;
		if (sc.hasNextInt()) deleteNumber=sc.nextInt();
        else return;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp.dat"));
			Gramata G;
		    boolean EOF = false;
		    
		    while (!EOF) {
		        try {
		            G = (Gramata) in.readObject();
		            if (numurs!=deleteNumber)out.writeObject(G);
		            numurs++;   
		        	} 
		        catch (EOFException e) {EOF = true;}
		    }
		    
		    in.close();  	
		    out.close();
		    File sourceFile=new File(filename);
			File tempFile=new File("temp.dat");
			
			 sourceFile.delete();
		        tempFile.renameTo(sourceFile);
		         
		}
		catch (Exception ex) {System.out.println(ex.getMessage());}
		
	}
	
	public static void edit() {
		File f = new File (filename);
        if (!f.exists()) {
            System.out.println("Faila " + filename + " nav");
            return;}
        System.out.println("Grāmatas numurs, par kuru informācija tiks editēta: ");
         int numurs = 1;
         int editNumurs;
         if (sc.hasNextInt()) editNumurs=sc.nextInt();
         else return;
            try {
            	ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
    			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp.dat"));
    			Gramata G;
    		    boolean EOF = false;
               
                while (!EOF) {
                    try {
                        
                        G = (Gramata) in.readObject();
                        if (numurs==editNumurs) {
                        	String newreaderID="--";
                        	String newreturnDate="--";
                        	G.print(numurs);
                        	System.out.println("Jaunā informācija par grāmatu: ");
                        	
                        	System.out.println("Grāmatas autora uzvārds: ");
                        	String Surname=sc.nextLine();
                        	
                        	System.out.println("Grāmatas autora vārds: ");
                        	String name=sc.nextLine();
                        	System.out.println("Grāmatas nosaukums: ");
                        	 String newbookName=sc.nextLine();
                        	System.out.println("Ievadiet grāmatas statusu  (izsniegta/plauktā)");
                        	 String newStatus=sc.nextLine();
                        	if (G.bookStatus.equals("izsniegta")) {
                        		System.out.println("Ievadiet lasītāja ID");
                   			  newreaderID=sc.nextLine();
                   			 	System.out.println("Ievadiet atdošanas datumu (dd.mm.gggg)");
                   			 	 newreturnDate=sc.nextLine();	
                   			 	
                   			 	
                        	}
                        	else {G.readerID="--"; G.returnDate="--";}
                        	G.changeInfo(Surname,name,newbookName,newStatus, newreaderID,newreturnDate);
                        	out.writeObject(G);
                        }
                        numurs++;
                        out.writeObject(G);
                    	}
                    catch (EOFException e) {
                        EOF = true;
                    	}
                }
                out.close(); 
                in.close();
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
	
	
	public static void view() {
		File f = new File (filename);
        if (!f.exists()) {
            System.out.println("Faila " + filename + " nav");
            return;
        }
       
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.printf("#   %-15s%-15s%-15s%-15s%-15s%-15s", "Uzvārds", "Vārds", "Nosaukums", "Statuss", "Lasītāja ID", "Nodošanas datums");
        System.out.print("\n-----------------------------------------------------------------------");
       
        int numurs = 1;
       
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
           
            Gramata G;
            boolean EOF = false;
           
            while (!EOF) {
                try {
                    G = (Gramata) in.readObject();
                    G.print(numurs++);
                	}
                catch (EOFException e) {
                    EOF = true;
                	}
            }
           
            in.close();     
        }
       
        catch (Exception ex) {System.out.println(ex.getMessage()); }
       
        System.out.println("\n-----------------------------------------------------------------------");
	}

}
