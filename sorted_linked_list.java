 /*
     * Java Program to Implement Sorted Circular Doubly Linked List
     */
    import java.util.Scanner;
     
    /*  Class Node  */
    class Node{
        protected int data;
        protected Node next, prev;

        /* Constructor */
        public Node(){next = null;prev = null;data = 0; }

        /* Constructor */
        public Node(int d, Node n, Node p){data = d; next = n; prev = p;}

        /* Function to set link to next node */
        public void setLinkNext(Node n){next = n; }

        /* Function to set link to previous node */
        public void setLinkPrev(Node p){ prev = p; }    

        /* Function to get link to next node */
        public Node getLinkNext(){return next; }

        /* Function to get link to previous node */
        public Node getLinkPrev(){return prev;}

        /* Function to set data to node */
        public void setData(int d){ data = d; }

        /* Function to get data from node */
        public int getData(){ return data; }
    }//class Node end
     
    /* Class linkedList */
    class linkedList{
        protected Node start, end;
        public int size;
        

        /* Constructor */
        public linkedList(){
            start = null;
            end = null;
            size = 0;
        }

        /* Function to check if list is empty */
        public boolean isEmpty(){
            return start == null;
        }

        /* Function to get size of list */
        public int getSize(){
            return size;
        }

        /* Function to insert element */
        public void insert(int val){
            Node nptr = new Node(val, null, null);
            Node tmp, ptr;        
            boolean ins = false;
            if (start == null){            
                nptr.setLinkNext(nptr);
                nptr.setLinkPrev(nptr);
                start = nptr;
                end = start;            
            }
            else if (val <= start.getData()){
                nptr.setLinkPrev(end);
                end.setLinkNext(nptr);
                start.setLinkPrev(nptr);
                nptr.setLinkNext(start);
                start = nptr;
            }
            else if (val >= end.getData()){
                end.setLinkNext(nptr);
                nptr.setLinkPrev(end);
                nptr.setLinkNext(start);
                start.setLinkPrev(nptr);
                end = nptr;
            }
            else{
                tmp = start;
                ptr = start.getLinkNext();
                while (ptr != null){
                    if (val >= tmp.getData() && val <= ptr.getData()){
                        tmp.setLinkNext(nptr);
                        nptr.setLinkPrev(tmp);
                        nptr.setLinkNext(ptr);
                        ptr.setLinkPrev(nptr);
                        ins = true;
                        break;
                    }
                    else{
                        tmp = ptr;
                        ptr = ptr.getLinkNext();
                    }
                }
                if (!ins){
                    tmp.setLinkNext(nptr);
                    nptr.setLinkPrev(tmp);
                }
            }
            size++;
        }
		
        /* Function to delete node at position */
        public void deleteAtPos(int pos){        
            if (pos == 1) {
                if (size == 1){
                    start = null;
                    end = null;
                    size = 0;
                    return; 
                }
                start = start.getLinkNext();
                start.setLinkPrev(end);
                end.setLinkNext(start);
                size--; 
                return ;
            }
            if (pos == size){
                end = end.getLinkPrev();
                end.setLinkNext(start);
                start.setLinkPrev(end);
                size-- ;
            }
            Node ptr = start.getLinkNext();
            for (int i = 2; i <= size; i++){
                if (i == pos){
                    Node p = ptr.getLinkPrev();
                    Node n = ptr.getLinkNext();
                    p.setLinkNext(n);
                    n.setLinkPrev(p);
                    size-- ;
                    return;
                }
                ptr = ptr.getLinkNext();
            }        
        }
        /* function to get the count of elements from interval -10; 10*/
        public int getCount(){
        	int count=0;
        	if (size>0) { 
        		Node ptr = start.getLinkNext();
        		if (start.getData()>=-10 && start.getData()<=10) count++;
                while (ptr.getLinkNext() != start){
                	if (ptr.getData()>=-10 && ptr.getData()<=10) count++;
                    
                    ptr = ptr.getLinkNext();}
        		
        	
        	if (end.getData()>=-10 && end.getData()<=10 && size>1 ) count++;
        	}
        	return count;
        	  }
        /* funkcija lai noskaidrotu vai saraksts ir pilns/full */
        public void full () {
        	if (size==10) System.out.println("Saraksts ir pilns.\n");
        	else  System.out.println("Saraksts nav pilns.\n");
        }
        
        /* Function to display status of list */
        public void display(){
            System.out.print("Sakārts divkāršsaistīts cirkulārs saraksts = ");
            Node ptr = start;
            if (size == 0){
                System.out.print("Tukšs saraksts\n");
                return;
            }
            if (start.getLinkNext() == start){
                System.out.print(start.getData()+ " <-> "+ptr.getData()+ "\n");
                return;
            }
            System.out.print(start.getData()+ " <-> ");
            ptr = start.getLinkNext();
            while (ptr.getLinkNext() != start){
                System.out.print(ptr.getData()+ " <-> ");
                ptr = ptr.getLinkNext();
            }
            System.out.print(ptr.getData()+ " <-> ");
            ptr = ptr.getLinkNext();
            System.out.print(ptr.getData()+ "\n");
        }
    }
     
    /* SortedCircularDoublyLinkedList */
  
            
public class sorted_linked_list{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
        linkedList list = new linkedList(); 
        System.out.println("Sakārtots divkāršaistītais cirkulārais saraksts\n"); 
       
        char ch;
        /*  Perform list operations  */
        do{
            System.out.println("\nDarbības ar sakārtoto divkāršaistīto cirkulāro sarakstu\n");
            System.out.println("1. ievietot elementu");
            System.out.println("2. izdzēst elementu pozīcijā");
            System.out.println("3. pārbaudīt vai tukšs");
            System.out.println("4. noskaidrot izmēru");
            System.out.println("5. elementu skaits, kas pieder intervālam [-10, 10]");
            System.out.println("6. pārbaudīt vai saraksts ir pilns");
            System.out.println("7. informācija par autori");
           
            int choice = scan.nextInt();            
            switch (choice){
            case 1 : 
            	if (list.getSize()==10) {System.out.println("Saraksts ir pilns."); break;}
            	else {System.out.println("Ievadiet integer vērtības elementu: ");
                list.insert( scan.nextInt() );                     
                break; }                         
            case 2 : 
                System.out.println("Ievadīt pozīciju");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Nederīga pozīcija\n");
                else
                    list.deleteAtPos(p);
                break;
            case 3 : 
                System.out.println("Vai saraksts ir tukšs?  "+ list.isEmpty()+"\n");
                break;                   
            case 4 : 
                System.out.println("Saraksta izmērs = "+ list.getSize() +" \n");
                break; 
            case 5 : 
                System.out.println("Elementu skaits no intervāla [-10;10] = "+ list.getCount() +" \n");
                break; 
            case 6 : 
            	list.full();
                break; 
            case 7 : 
            	System.out.println("181RDB178 Jolanta Bērziņa  10");
                break; 
            
            default : 
                System.out.println("Nekorekta ievade \n ");
                break;   
            }

            /*  Display List  */ 
            list.display();
            System.out.println("\nVai turpināt (ievadiet y vai n) \n");
            ch = scan.next().charAt(0);            
            } while (ch == 'Y'|| ch == 'y'); 
        scan.close();
    }
}
		
