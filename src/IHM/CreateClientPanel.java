package IHM;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateClientPanel {
	
	private JPanel mainPanel = new JPanel();
	private JButton retour;
	
	private static final Dimension MAIN_SIZE = new Dimension(400,200);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {  	
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    JFrame frame = new JFrame("Creer un nouveau client");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
	
	public CreateClientPanel() {
		retour = new JButton("Retour");
		mainPanel.add(retour);
	}
	
	public JComponent getMainComponent() {
		return mainPanel;
	}

	public void addBackBtnActionListener(ActionListener listener) {
	      retour.addActionListener(listener);
	}

}
