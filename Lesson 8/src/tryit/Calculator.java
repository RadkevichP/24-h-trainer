package tryit;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	
	//Declare all calculator components
	private JPanel windowContent;
	private JTextField displayField;
	private JButton[] buttons;
	private String[] buttonNames;
	
	private GridBagLayout gridBagLayout;
	private GridBagConstraints constraints;
	
	Calculator() {
		super("Calculator");
		
		windowContent = new JPanel();
		
		//set the layout manager for this panel
		gridBagLayout = new GridBagLayout();
		windowContent.setLayout(gridBagLayout);
		
		//create the instance of GridBagConstraints
		constraints = new GridBagConstraints();
		
		//setting constraints for displayField
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.anchor = GridBagConstraints.CENTER;
		
		//adding displayField
		displayField = new JTextField();
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		addComponent(windowContent, displayField, 0, 0, 8, 1);
		
		//setting buttons names
		String[] buttonNames = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "=", "+" , "-" , "*", "/"};
		
		//Setting buttons
		buttons = new JButton[buttonNames.length];
		
		//adding buttons
		for(int i = 0; i< buttonNames.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
		}
		
		// add the first button row
		addComponent(windowContent, buttons[1], 1, 0, 2, 1);
		addComponent(windowContent, buttons[2], 1, 2, 2, 1);
		addComponent(windowContent, buttons[3], 1, 4, 2, 1);
		addComponent(windowContent, buttons[12], 1, 6, 2, 1);
		
		//add the second button row
		addComponent(windowContent, buttons[4], 2, 0, 2, 1);
		addComponent(windowContent, buttons[5], 2, 2, 2, 1);
		addComponent(windowContent, buttons[6], 2, 4, 2, 1);
		addComponent(windowContent, buttons[13], 2, 6, 2, 1);
		
		//add the third button row
		addComponent(windowContent, buttons[7], 3, 0, 2, 1);
		addComponent(windowContent, buttons[8], 3, 2, 2, 1);
		addComponent(windowContent, buttons[9], 3, 4, 2, 1);
		addComponent(windowContent, buttons[14], 3, 6, 2, 1);
		
		//add the fourth button row
		addComponent(windowContent, buttons[0], 4, 0, 2, 1);
		addComponent(windowContent, buttons[10], 4, 2, 2, 1);
		addComponent(windowContent, buttons[11], 4, 4, 2, 1);
		addComponent(windowContent, buttons[15], 4, 6, 2, 1);
		
		
		
		//set the frame content
		setContentPane(windowContent);
		setVisible(true);
		pack();
		
		//action when closing
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	

	private void addComponent(Container container, Component component, int row, int column, int width, int height) {

		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridheight = height;
		constraints.gridwidth = width;
		gridBagLayout.setConstraints(component, constraints);
		container.add(component);
	} //end method addComponent



	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		

	}

}
