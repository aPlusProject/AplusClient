package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class ConnectionPanel extends JFrame {

	private JPanel mainPanel = new JPanel();
	private JButton connection = new JButton("Connexion");
	   //private JButton exit = new JButton("Exit");
	private JButton exit;
	private JButton baz = new JButton("baz");

	public ConnectionPanel() {
	      mainPanel.setLayout(new FlowLayout());
	      connection = new JButton("Connexion");
	      exit = new JButton("exit");

	      mainPanel.add(new JLabel("Interface de connexion"));
	      mainPanel.add(connection);
	      mainPanel.add(exit);

	      exit.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            Window win = SwingUtilities.getWindowAncestor(mainPanel);
	            win.dispose();
	         }
	      });
	      
	      
	   }

	   public void addConnectionActionListener(ActionListener listener) {
	      connection.addActionListener(listener);
	   }

	   public JComponent getMainComponent() {
	      return mainPanel;
	   }

}
