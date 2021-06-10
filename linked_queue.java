import java.util.*;

/*  Class Node  */

class Node{
	protected int data;
	protected Node link;

    /*  Constructor  */
			public Node(){ link = null; data = 0;}    

    /*  Constructor  */
			public Node(int d,Node n){data = d; link = n;}    

    /*  Function to set link to next Node  */
			public void setLink(Node n) {link = n;}    

    /*  Function to set data to current Node  */
			public void setData(int d){ data = d;}    

    /*  Function to get link to next node  */
			public Node getLink() {return link;}    

    /*  Function to get data from current Node  */
			public int getData() {return data;}

	}//class Node end

class linkedQueue {
		protected Node front, rear;
		public int size;

    /* Constructor */
		public linkedQueue(){
				front = null;
				rear = null;
				size = 0;}    

    /*  Funkcija, kas pārbaua vai rinda ir tukša */
		public boolean isEmpty() {return front == null;}    

    /*  Funkcija, kas atgriež rindas izmēru */
		public int getSize() {return size;}    

    /*  funkcija, kas ievieto elementu rindā*/
		public void enqueue(int data)
				{ Node nptr = new Node(data, null);
					if (rear == null) {front = nptr;rear = nptr;}
					else{rear.setLink(nptr); rear = rear.getLink();}
					size++ ;}    

    /*  funkcija, kas ziņem elementu nno rindas */
		public int dequeue() {
				if (isEmpty() ) throw new NoSuchElementException("Underflow Exception");
					Node ptr = front;
					front = ptr.getLink();        
					if (front == null) rear = null;
					size-- ;        
					return ptr.getData();}    

    /*  funkcija, kas parbauda front /pirmo elementu rindā*/
		public int peek()
				{ if (isEmpty() )
					throw new NoSuchElementException("Underflow Exception");
					return front.getData();}    

    /*  funkcija, kas izvada rindu un tas eleentus */
		public void display()
			{System.out.print("\nSaistītā formā attēlotā rinda = ");
			if (size == 0){System.out.print("Tukša\n"); return ;}
			Node ptr = front;
				while (ptr != rear.getLink() )
					{System.out.print(ptr.getData()+" ");
					ptr = ptr.getLink();}
					System.out.println();  }
		
		/* funkcija parbauda vai rinda ir pilna*/
		public boolean isFull() {
			return (size==10);
		}
		
		/* funkcija, kas apēķina pāra skaitļu daudzumu rindā*/
		public int evenNumbers() {
			int sum=0;
			if (size == 0){System.out.print("Tukša rinda\n");}
			else  {
				Node ptr=front;
				while (ptr != rear.getLink() ) {	
				if (ptr.getData()%2==0) sum++;
				ptr = ptr.getLink(); }
				}
			return sum;
		
		}
}//class linked queue end

public class linked_queue{

	public static void main(String[] args) {
		System.out.println("Saistītā formā attēlotā rinda");
		Scanner scan = new Scanner(System.in); 

        /* izveido object of class linkedQueue */   
        linkedQueue lq = new linkedQueue();  
        char ch;        

        do
        {
            System.out.println("\nDarbības ar rindu");
            System.out.println("1. Ievietot elementu");
            System.out.println("2. Izdzēst elementu");
            System.out.println("3. Pārbaudīt elementu");
            System.out.println("4. Pārbaudīt vai rinda ir tukša");
            System.out.println("5. Noskaidrot rindas izmēru");
            System.out.println("6. Pārbaudīt vai rinda ir pilna");
            System.out.println("7. Aprēķināt pāra skaitļu daudzumu rindā");
            System.out.println("8. Informācija par autori");
            int choice = scan.nextInt();
            switch (choice)

            {
            case 1 : 
                System.out.println("Ievadiet veselu skaitli, kas jāievieto rindā");
                lq.enqueue( scan.nextInt() ); break;                         
            case 2 : 
                try  { System.out.println("Izdzēstais elements = "+ lq.dequeue()); }
                catch (Exception e)
                	{System.out.println("Error : " + e.getMessage()); }    
                break;                         

            case 3 : 
                try {System.out.println("Pārbaudīt elementu = "+ lq.peek());}
                catch (Exception e)
                	{ System.out.println("Error : " + e.getMessage());}
                break;                         

            case 4 : 
                System.out.println("Vai rinda ir tukša = "+ lq.isEmpty()); break;
            case 5 : 
                System.out.println("Rindas izmērs = "+ lq.getSize());break; 
            case 6:
            	System.out.println("Vai rinda ir pilna = "+ lq.isFull()); break;
            case 7:
            	System.out.println("Pāra skaitļu daudzums rindā = "+ lq.evenNumbers()); break;
            case 8:
            	System.out.println("181RDB178 Jolanta Bērziņa 10. grupa");break;
            default : 
                System.out.println("Nepareiza ievade \n "); break;
            }//switch end                

            /* izvadīt rindu */        
            lq.display();
            System.out.println("\nVei vēlaties turpināt(Ievadiet 'y' vai 'n') \n");

            ch = scan.next().charAt(0);            

        } while (ch == 'Y'|| ch == 'y');                                                            
        scan.close();
    }//public static void end 

}
