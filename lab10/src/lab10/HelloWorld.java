package lab10;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HelloWorld {

	private static void createAndShowGUI(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("HelloWorld - from JFrame");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(30,	30, 10, 30));
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Hello World - from JLabel");

		
		JButton button = new JButton("Terminate the program");
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu: (from Jmenu)");
		menuBar.add(menu);
		JMenuItem item = new JMenuItem("First item");
		menu.add(item);
		JMenuItem item_quit = new JMenuItem("Quit");
		menu.add(item_quit);
		
		
		CloseListener cl = new CloseListener();
		button.addActionListener(cl);
		item_quit.addActionListener(cl);
		panel.add(button);
		panel.add(menuBar);
		
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

class CloseListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	
}
