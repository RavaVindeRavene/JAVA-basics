import java.util.Scanner;
import java.util.Stack;


class Node
{
	Node right;
	Node left;
	int data;

	// Default constructor
	public Node( int data ) 
	{
		this.data = data;
		left = right = null;
	}
}

public class binary_tree
{
	// Class global variables
	public static Node Root;
	public static int virsotnes = 0;
	
	// Self constructor
	public binary_tree( ) { binary_tree.Root = null; }
	
	
	// Count left nodes, recursive approach
	private int countTwoChildren( Node node )
	{
		if ( node == null ) return 0;
		if ( node.left != null && node.right != null ) 
			{ 
			return 1 +countTwoChildren( node.left ) + countTwoChildren( node.right );}
		else
		{return countTwoChildren( node.left ) + countTwoChildren( node.right );}
	}
	
	public int countTwoChildren() {return countTwoChildren(Root);}
	
        
        // Count cells that has negative data value
        private int count_negative( Node root )
        {
        	if ( root == null ) return 0;
        	
        	int negativs = count_negative( root.left ) + count_negative( root.right );
        	
        	if( root.data < 0 ) return negativs + 1;
        	else return negativs;
	}
        
        // Output preordered binary tree array
	public void izvade_preorder( )
	{
		if ( Root == null ) return;
		
		Stack <Node> stk = new Stack <Node>( );
		stk.push( Root );
		
		while ( stk.empty( ) == false ) 
		{
			Node mynode = stk.peek( );
			System.out.print( mynode.data + " " );
			stk.pop( );
			
			if ( mynode.right != null ) stk.push( mynode.right );
			if ( mynode.left != null ) stk.push( mynode.left );
		}
	}
	
	// Overloaded negative data cells counter
	public int count_negative( ) { return count_negative( Root ); }
	
	// Insert value into binary tree
	public void insert( int id )
	{
		
		Node new_node = new Node( id );
		
		if ( Root == null ) 
		{
			Root = new_node;
			return;
		}
		
		Node current = Root;
		Node parent = null;
		
		while ( true ) 
		{
			parent = current;
			
			if ( id < current.data )
			{
				current = current.left;
				
				if ( current == null )
				{
					parent.left = new_node;
					return;
				}
			}
			else 
			{
				current = current.right;
				
				if ( current == null )
				{
					parent.right = new_node;
					return;
				}
			}
		}
	}

	public static void main( String[ ] cmd_args )
	{
		binary_tree bin_t = new binary_tree( );
		Scanner Get = new Scanner( System.in );
		
		System.out.println( "Jolanta Bērziņa, 10. grupa, 181RDB178" );
		System.out.println( "\nBinarais meklesanas koks" );
		
		boolean izveidots = false;
		boolean running = true;
		int izmers=1;
		int choice = 0;
		int add;
		
		while ( running ) 
		{
			// If binary tree is not created yet
			if ( !izveidots )
			{
				System.out.print( "\nLai izveidot koku, ievadiet vertibu \"saknes\" elementam: " );
				
				try
				{
					add = Get.nextInt( );
					bin_t.insert( add );
					izveidots = true;
				}
				catch ( Exception EXC )
				{
					System.out.println( "Kluda, jaievada integer tipa vertibu ...\nProgramma pabeigta!" );
					break;
				}
				
				System.out.println( "\nBinarais koks ir izveidots!" );
			}
			
			// If tree was created
			if (izveidots) 
			{
				System.out.println( "\nIzvelieties opciju:" );
				System.out.println( "\t1) Pievienot elementu." );
				System.out.println( "\t2) Izvadit virsotnes ( Preorderiali )." );
				System.out.println( "\t3) Saskaitīt cik kokā ir virsotnes, kurām ir divi bērni." );
				System.out.println( "\t4) Izvadīt negatīvo elementu skaitu." );
				System.out.println(" \t0) Iziet no programmas.");

				try 
				{ 
					System.out.print( "\nIevadiet opciju: " );
					choice = Get.nextInt( ); 
				}
				catch ( Exception EXC ) { System.out.println( "Kļūda, jāievada integer tipa vērtiba" ); }
				
				switch ( choice ) 
				{
					case 1 :
						if (izmers==15) { System.out.println( "Koks ir pilns" ); break; }
						else {
						System.out.print( "Ievadiet vērtibu: " );
						int vertiba = 0;
						try { vertiba = Get.nextInt( ); }
						catch ( Exception EXC ) { System.out.println( "Kļūda, jāievada integer tipa vērtiba" ); }
						bin_t.insert(vertiba);
						izmers++;
						break;}
						
					case 2 :
						System.out.print( "Virsotnes: " );
						bin_t.izvade_preorder( );
						System.out.println( );
						break;
						
					case 3 :
						System.out.println( "Virsotņu skaits,kurām ir divi bērni: " + bin_t.countTwoChildren( Root ) );
						
						break;
						
					case 4:
						System.out.println( "Negatīvo elementu skaits: " + bin_t.count_negative( ) );
						break;
						
					case 0 :
						running = false;
						System.out.println( "Programma pabeigta!" );
						break;
						
					default :
						break;
				}
			}
		}
	}
}