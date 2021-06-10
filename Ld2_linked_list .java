import java.util.Scanner;
import java.util.Random;
 
/*  Class Node  */
class Node{
    protected float data;
    protected Node link;
	public Node next;
	public Node head = null;

    /*  Constructor  */
    public Node(){ link = null; data = 0;}    

    /*  Constructor  */
    public Node(float rndReal,Node n){ data = rndReal;link = n; }    

    /*  Function to set link to next Node  */
    public void setLink(Node n){ link = n; }    

    /*  Function to set data to current Node  */
    public void setData(int d){data = d; }    

    /*  Function to get link to next node  */
    public Node getLink(){return link; }    

    /*  Function to get data from current Node  */
    public float getData(){return data;}
}// node class

/* Class linkedList */
class linkedList{
    protected Node start;
    protected Node end ;
    public int size ;
    

    /*  Constructor  */
    public linkedList(){ start = null;end = null;size = 0;}

    /*  Function to check if list is empty  */
    public boolean isEmpty(){return start == null; }

    /*  Function to get size of list  */
    public int getSize(){ return size;}    

    /*  Function to insert an element at beginning  */
    public void insertAtStart(int val){
        Node nptr = new Node(val, null);   size++ ;    
        if(start == null){ start = nptr;end = start;}
        else{nptr.setLink(start);start = nptr;}
    }

    /*  Function to insert an element at end  */
    public void insertAtEnd(float rndReal){
        Node nptr = new Node(rndReal,null); size++ ;    
        if(start == null){start = nptr; end = start;}
        else{end.setLink(nptr); end = nptr; }
    }
    
    /*  Function to insert an element at position  */
    public void insertAtPos(float val , int pos){
        Node nptr = new Node(val, null);                
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++){
            if (i == pos){
                Node tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break; }
            ptr = ptr.getLink();
        }
        size++ ;
    }

    
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos){        
        if (pos == 1){ start = start.getLink();size--; return ; }
        if (pos == size){Node s = start; Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++){
            if (i == pos){
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }    

    /*  Function to display elements  */
    public void display(){
        if (size == 0){
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ " ");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ " ");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
    
    public  void getElement() { 
    	
        float max=-11;
        Node ptr=start;
        if (start.getData()>max) {
        	max=start.getData();
        }
    	ptr=start.getLink();
    	while (ptr.getLink()!=null)
    	{if (ptr.getData()>max) {
    		max=ptr.getData();
    	}
    	ptr=ptr.getLink();
    	}
    	if (end.getData()>max) {
    		max=end.getData();
    	}
    	
           
            System.out.println("Maksimālais elements: "+ max);  
          
    }  
}


// vienkāršsaistītais saraksts
public class Ld2_linked_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner scan = new Scanner(System.in);
	     Random rnd = new Random();
	     linkedList list = new linkedList(); 
	     System.out.println("Saraksts:");
	     for (int i=0;i<10;i++) {
	        	float rndReal = -10 +rnd.nextFloat()*20;
	        	while (rndReal==0) {
	        		rndReal = -10 +rnd.nextFloat()*20;
	        	}
	        	list.insertAtEnd(rndReal);
	        }
	        
	        list.display();
	        System.out.println();
	        list.getElement();
	        System.out.println("Ievadiet elementa pozīciju, kura jāizdzēš:");
	        int poz = scan.nextInt() ;
	        if (poz < 1 || poz > list.getSize() )
	            System.out.println("Pozīcija neeksistē\n");
	        else
	            list.deleteAtPos(poz);
	        
	        	System.out.print("Jaunais sarkasts: ");
	            list.display();
	}

}
