package IHM;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import socket.SocketClient;

public class GUIFrame extends JFrame {

	private static final String CO = "connection";
	private static final String ALLCLIENTS = "allClientsDisplay";
	private ConnectionPanel coPanel = new ConnectionPanel();
	private static AllClientsDisplayPanel allClientsPanel;
	private CardLayout cardlayout = new CardLayout();
	private JPanel mainPanel = new JPanel(cardlayout);
	private SocketClient sck;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		allClientsPanel = new AllClientsDisplayPanel();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JComponent getMainComponent() {
		return mainPanel;	
	}
	
	public static void createAndShowUI() {
		JFrame frame = new JFrame("Liste des clients");
        frame.getContentPane().add(new JScrollPane(new GUIFrame().getMainComponent()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public GUIFrame() {
		mainPanel.add(coPanel.getMainComponent(), CO);
		mainPanel.add(allClientsPanel.getMainComponent(), ALLCLIENTS);
		
		coPanel.addConnectionActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				InetAddress localAdr= null;
				
				try {
					localAdr = InetAddress.getLocalHost();
				} catch (UnknownHostException e2) {
					e2.printStackTrace();
				}
				if (localAdr != null) {
					
					try {
						sck = new SocketClient(localAdr.getHostAddress(),143);
						sck.send("1");
						sck.receive();
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				 
				cardlayout.show(mainPanel, ALLCLIENTS);
				
			}
			
		});
		
		allClientsPanel.addBackBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, CO);
			}
		});
	}

}
