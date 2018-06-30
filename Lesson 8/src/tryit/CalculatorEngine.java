package tryit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CalculatorEngine implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(null, "Somrthing happened...", "Just a test", JOptionPane.PLAIN_MESSAGE);

	}

}
