package com.practicaljava.lesson10.bike_order;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderWindow extends JFrame {

	private BikeOrder bikeOrder;
	private String selectedName = "";
	private int bikeQuantity;

	// constructor creates new CUI window
	public OrderWindow() {

		bikeOrder = new BikeOrder();
		// prepare bike names for the JCoboBox
		String[] bikeNames = { "", "KidDream", "JuniorArrow", "TinyLady", "KingKong" };

		// create new panel for ordering
		JPanel orderPanel = new JPanel();

		// set layout manager for the panel
		GridLayout gl = new GridLayout(3, 2);
		orderPanel.setLayout(gl);

		// create GUI components
		JLabel bikeNameLabel = new JLabel("Select model: ");
		JComboBox nameBox = new JComboBox(bikeNames);

		// connect nameBox with ActionListener

		/*
		 * nameBox.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent event) { JComboBox combo = (JComboBox)
		 * event.getSource(); selectedName = combo.getSelectedItem().toString(); } });
		 */

		nameBox.addActionListener(event -> {
			{
				JComboBox combo = (JComboBox) event.getSource();
				selectedName = combo.getSelectedItem().toString();
			}
		});

		JLabel quantityLabel = new JLabel("Quantity: ");
		final JTextField quantityField = new JTextField(20);

		JButton orderButton = new JButton("Order");
		final JLabel orderStatus = new JLabel("");

		// connect orderButton with ActionListener
		orderButton.addActionListener(event -> {
			try {
				if (selectedName == "") {
					orderStatus.setText("Please choose model!");
				} else {
					bikeQuantity = Integer.parseInt(quantityField.getText());
					bikeOrder.validateOrder(selectedName, bikeQuantity);
					orderStatus.setText(bikeOrder.getOrder());
				}

			} catch (NumberFormatException e) {
				orderStatus.setText("Quantity must be a number!");
			} catch (TooManyBikesException tmbe) {
				orderStatus.setText(tmbe.getMessage());
			}
		});

		// add all GUI components to the panel
		orderPanel.add(bikeNameLabel);
		orderPanel.add(nameBox);
		orderPanel.add(quantityLabel);
		orderPanel.add(quantityField);
		orderPanel.add(orderButton);
		orderPanel.add(orderStatus);

		add(orderPanel);

		setTitle("Place your order");
		setSize(900, 200);
		setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new OrderWindow();
	}
}
