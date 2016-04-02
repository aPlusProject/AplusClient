package IHM;
import model.EmployeePanelModel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AllClientsDisplayPanel {

    /*Statement ps;
    ResultSet rs;

    private static ArrayList<String> entete;
    private static ArrayList<ArrayList<String>> tableClient;
    */

    //launch the application
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
    	
    	EmployeePanelModel modelEmployee = new EmployeePanelModel(false,1);
    	/*tableClient = modelEmployee.getArrayOfClients();
    	entete = modelEmployee.getEntete();*/
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                   /* Object[] tempEntete = entete.toArray();
                    String[][] tempTable = new String[tableClient.size()][];
                    int i = 0;
                     for (List<String> next : tableClient) {
                        tempTable[i++] = next.toArray(new String[next.size()]);
                      }
                    JTable endTable = new JTable(tempTable,tempEntete);*/
                    JFrame frame = new JFrame("Liste des clients");
                    //frame.getContentPane().add(new JScrollPane(endTable));
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
	
	private static final Dimension MAIN_SIZE = new Dimension(400,200);
	private JPanel mainPanel = new JPanel();
	
	//private static ArrayList<String> entete;
    //private static ArrayList<ArrayList<String>> tableClient;
	
	private JButton retour;
	
	public AllClientsDisplayPanel() throws ClassNotFoundException, SQLException {
		
		/*EmployeePanelModel modelEmployee = new EmployeePanelModel(false,1);
    	tableClient = modelEmployee.getArrayOfClients();
    	entete = modelEmployee.getEntete();
		
		Object[] tempEntete = entete.toArray();
        String[][] tempTable = new String[tableClient.size()][];
        int i = 0;
         for (List<String> next : tableClient) {
            tempTable[i++] = next.toArray(new String[next.size()]);
          }
        JTable endTable = new JTable(tempTable,tempEntete);*/
		
		retour = new JButton("Retour");
		//mainPanel.add(endTable);
		mainPanel.add(retour);
		//mainPanel.setPreferredSize(MAIN_SIZE);
	}
	
	public JComponent getMainComponent() {
		return mainPanel;
	}

	public void addBackBtnActionListener(ActionListener listener) {
	      retour.addActionListener(listener);
	   }

}