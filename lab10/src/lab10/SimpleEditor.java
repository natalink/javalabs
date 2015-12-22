package lab10;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;



public class SimpleEditor {
	
	
	
	private static void createAndShowGUI(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Text Editor");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(130,130, 100, 130));
		frame.getContentPane().add(panel);
		JTextArea text_area = new JTextArea(50, 50);
		JScrollPane jp = new JScrollPane(text_area);
		panel.add(jp);
		JButton save_button = new JButton("Save"); 
		
		File yourFile = new File("save_text.txt");
		if(!yourFile.exists()) {
		    try {
				yourFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		try {
			FileOutputStream oFile = new FileOutputStream(yourFile, false);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		CloseListener1 cl = new CloseListener1(yourFile, text_area);
		save_button.addActionListener(cl);
		panel.add(save_button, BorderLayout.SOUTH);
		JButton button = new JButton("Terminate the program");
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run() {
				createAndShowGUI();
			}
		}
				
				
		);
	}
	
}

class CloseListener1 implements ActionListener {
	File file;
	JTextArea textArea;	
	public CloseListener1(File file, JTextArea textArea) {
		this.file = file;
		this.textArea = textArea ;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(file, false));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
	}
	
}


