import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class taskPlanner 
{
	private JFrame mainFrame;	// Top level window, with a title and border
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public taskPlanner()
	{
		setupGUI();
	}
	public static void main(String[] args)
	{
		taskPlanner taskPlannerApp = new taskPlanner();  
		taskPlannerApp.showEvent();       
	}
	private void setupGUI()
	{
		mainFrame = new JFrame("Task Planner");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 1));

		headerLabel = new JLabel("",JLabel.CENTER );
		statusLabel = new JLabel("",JLabel.CENTER);        
		statusLabel.setSize(350,100);

		mainFrame.addWindowListener(
			new WindowAdapter() 
				{
					public void windowClosing(WindowEvent windowEvent)
					{
						System.exit(0);
					}        
				}
		);    
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);  
	}
	private void showEvent()
	{
		headerLabel.setText("Control in action: Button"); 

		JButton okButton = new JButton("OK");
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		cancelButton.setActionCommand("Cancel");

		okButton.addActionListener(new ButtonClickListener()); 
		submitButton.addActionListener(new ButtonClickListener()); 
		cancelButton.addActionListener(new ButtonClickListener()); 

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);       

		mainFrame.setVisible(true);  
	}
	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			String command = e.getActionCommand();  

			if( command.equals( "OK" ))  
			{
				statusLabel.setText("Ok Button clicked.");
			} else if( command.equals( "Submit" ) )  
			{
				statusLabel.setText("Submit Button clicked."); 
			} else 
			{
				statusLabel.setText("Cancel Button clicked.");
			}		
		}		
	}
}
