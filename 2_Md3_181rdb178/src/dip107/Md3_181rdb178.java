package dip107;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;


public class Md3_181rdb178 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;
	private JTextField inputField;
	public static int elementCount=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Md3_181rdb178 frame = new Md3_181rdb178();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public boolean inputFieldIsEmpty() {
		if (inputField.getText().equals(""))return true;else return false;}
	
	public Md3_181rdb178() {
		setTitle("Md3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputField = new JTextField();
		inputField.requestFocusInWindow();
		inputField.setBounds(5, 5, 304, 30);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		DefaultListModel<String> defaultListModel=new DefaultListModel<String>();
		DefaultListModel<String> resultListModel=new DefaultListModel<String>();
		
		JList<String> inputList = new JList<String>();
		inputList.setVisibleRowCount(20);
		inputList.setBounds(5, 92, 140, 160);
		contentPane.add(inputList);
		
		JList<String> resultList = new JList<String>();
		resultList.setVisibleRowCount(20);
		resultList.setEnabled(false);
		resultList.setBounds(169, 92, 140, 160);
		contentPane.add(resultList);
	
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputList.setModel(defaultListModel);
				if(inputFieldIsEmpty()){System.out.println("Nekas netika ievadīts");}
				else{
						defaultListModel.addElement(inputField.getText());
						inputField.setText("");
						elementCount++;
						}
			}
		});
		btnNewButton.setBounds(5, 36, 145, 45);
		contentPane.add(btnNewButton);
		
		inputField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	inputList.setModel(defaultListModel);
					if(inputFieldIsEmpty()){System.out.println("Nekas netika ievadīts");}
					else{
							defaultListModel.addElement(inputField.getText());
							inputField.setText("");
							elementCount++;
							}
	            }
	        }

	    });
		
		
		JButton btnNewButton_1 = new JButton("Run");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i=0;i<elementCount;i++) {
					String textLine=java.lang.String.valueOf(inputList.getModel().getElementAt(i));
					//System.out.println(textLine);
					String [] vardi = textLine.split("\\s+");
					int varduSkaits=vardi.length;
					//System.out.println(varduSkaits);
					String resultText=vardi[0];
					for(int j=1;j<varduSkaits;j++) {
						//System.out.println(vardi[j]);
						if (vardi[j].length()<resultText.length()) resultText=vardi[j];
						
					}
					resultListModel.addElement(resultText);
				}
				resultList.setModel(resultListModel);
				
			}
		});
		btnNewButton_1.setBounds(169, 36, 140, 45);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [] selectedItemsInputList=inputList.getSelectedIndices();
				for (int i=0; i<selectedItemsInputList.length;i++) {
					defaultListModel.remove(selectedItemsInputList[i]);
					elementCount--;
				};
			}
		});
		btnNewButton_2.setBounds(5, 263, 140, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resultListModel.removeAllElements();
				
			}
		});
		btnNewButton_3.setBounds(169, 263, 140, 37);
		contentPane.add(btnNewButton_3);
		
		
		
	}
}
