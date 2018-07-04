package com.practicaljava.lesson9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CalculatorEngine implements ActionListener {

	// declare error message
	public static final String ERROR_MESSAGE = "Error!";

	// declaring events
	public static final int DIGIT_BUTTON_PRESSED = 1;
	public static final int OPERATION_BUTTON_PRESSED = 2;
	public static final int EQUAL_BUTTON_PRESSED = 3;

	// current state
	public int currentEvent;
	public String currentButtonValue;

	private Calculator calculator;
	private Operations operation;
	private Double firstArg;
	private Double secondArg;
	private Double operationResult;

	public CalculatorEngine(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// Get the source object of this action
		Object eventSource = actionEvent.getSource();

	}

	// possible calculator preconditions

	// no one argument defined
	private Boolean x1() {
		if (firstArg == null && secondArg == null && operationResult == null)
			return true;
		else
			return false;
	}

	// first argument defined
	private Boolean x2() {
		if (firstArg != null && secondArg == null && operationResult == null)
			return true;
		else
			return false;
	}

	// first and second arguments are defined
	private Boolean x3() {
		if (firstArg == null && secondArg != null && operationResult != null)
			return true;
		else
			return false;
	}

	// calculation processor
	private Double doCalculation() {

		Double result = null;

		switch (operation) {
		case ADDITION:
			result = firstArg + secondArg;
			break;
		case SUBTRACTION:
			result = firstArg - secondArg;
			break;
		case DIVISION:
			if (secondArg != 0)
				result = firstArg / secondArg;
			break;
		case MULTIPLYING:
			result = firstArg * secondArg;
			break;
		case ILLEGAL_OPERATION:
		}
		return result;
	} // end of doCalculation
	
	private Operations getOperationFromString(String string) {
		if(string == "+") {
			return Operations.ADDITION;
		} else if(string == "-") {
			return Operations.SUBTRACTION;
		} else if(string == "*") {
			return Operations.MULTIPLYING;
		} else if(string == "/") {
			return Operations.DIVISION;
		} else {
			return Operations.ILLEGAL_OPERATION;
		}
	} //end method getOperationFromString
	// Allow avoid throwing the NumberFormatException on the invalid string
	// Method has copied from Java Platform Standard Edition 6 API Specification
	// (http://bit.ly/hyJtWP)
	private Double parceStringToFloat(String myString) {
		Double ret = null;

		final String Digits = "(\\p{Digit}+)";
		final String HexDigits = "(\\p{XDigit}+)";
		// an exponent is 'e' or 'E' followed by an optionally
		// signed decimal integer.
		final String Exp = "[eE][+-]?" + Digits;
		final String fpRegex = ("[\\x00-\\x20]*" + // Optional leading
													// "whitespace"
				"[+-]?(" + // Optional sign character
				"NaN|" + // "NaN" string
				"Infinity|" + // "Infinity" string

				// A decimal floating-point string representing a finite
				// positive
				// number without a leading sign has at most five basic pieces:
				// Digits . Digits ExponentPart FloatTypeSuffix
				//
				// Since this method allows integer-only strings as input
				// in addition to strings of floating-point literals, the
				// two sub-patterns below are simplifications of the grammar
				// productions from the Java Language Specification, 2nd
				// edition, section 3.10.2.

				// Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
				"(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" +

				// . Digits ExponentPart_opt FloatTypeSuffix_opt
				"(\\.(" + Digits + ")(" + Exp + ")?)|" +

				// Hexadecimal strings
				"((" +
				// 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
				"(0[xX]" + HexDigits + "(\\.)?)|" +

				// 0[xX] HexDigits_opt . HexDigits BinaryExponent
				// FloatTypeSuffix_opt
				"(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

				")[pP][+-]?" + Digits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*");// Optional
																				// trailing
																				// "whitespace"

		if (Pattern.matches(fpRegex, myString))
			ret = Double.valueOf(myString); // Will not throw NumberFormatException

		return ret;
	}

	public void processButtonClick(JButton button) {
		// get the name of pressed button
		currentButtonValue = button.getText();

		if (currentButtonValue == "=") {
			currentEvent = EQUAL_BUTTON_PRESSED;
		} else if (currentButtonValue == "+" || currentButtonValue == "-" || currentButtonValue == "*"
				|| currentButtonValue == "/") {
			currentEvent = OPERATION_BUTTON_PRESSED;
		} else {
			currentEvent = DIGIT_BUTTON_PRESSED;
		}

		if (calculator.getDisplayFieldText().equals(ERROR_MESSAGE)) {
			calculator.setDisplayFieldText("");
		}

		switch (currentEvent) {
		// digit button pressed
		case 1:
			// First argument input or second argument input
			if (x1() || x2()) {
				calculator.setDisplayFieldText(calculator.getDisplayFieldText() + currentButtonValue);
			}

			// The last operation repeated (the wrong button click order)
			if (x3()) {
				calculator.setDisplayFieldText(currentButtonValue);
				firstArg = null;
				secondArg = null;
				operationResult = null;
			} // on exit we have x1 calculation precondition
			break;
		// OPERATION_BUTTON_PRESSED
		case 2:
			operation = getOperationFromString(currentButtonValue);
			// First argument input ended (the correct button click order)
			if (x1()) {
				firstArg = parceStringToFloat(calculator.getDisplayFieldText());
				calculator.setDisplayFieldText("");
				break;
			}
			// Second argument input or the last operation repeated (the wrong button click
			// order)
			if (x2() || x3()) {
				calculator.setDisplayFieldText("");
				firstArg = null;
				secondArg = null;
				operationResult = null;
			} // on exit we have the x1 calculation precondition

			break;
		// EQUAL_BUTTON_PRESSED
		case 3:
			// First argument input (the wrong button click order)
			if (x1()) {
				calculator.setDisplayFieldText("");
				break;
			}
			// Second argument input ended, operation calculation (the correct button click
			// order)
			if (x2()) {
				secondArg = parceStringToFloat(calculator.getDisplayFieldText());
				if (secondArg != null) {
					operationResult = doCalculation();
					firstArg = null;
					if (operationResult == null) {
						calculator.setDisplayFieldText(ERROR_MESSAGE);
						secondArg = null;
						// on exit we have the x1 calculation precondition
					} else {
						calculator.setDisplayFieldText(Double.toString(operationResult));
						// on exit we have the x3 calculation precondition
					}
				}
				firstArg = null;
				break;
			}
			// The last operation repeated (the correct button click order)
			if (x3()) {
				if (operationResult.equals(parceStringToFloat(calculator.getDisplayFieldText()))) {
					firstArg = operationResult;
					if (secondArg != null) {
						operationResult = doCalculation();
						firstArg = null;
						if (operationResult == null) {
							calculator.setDisplayFieldText(ERROR_MESSAGE);
							secondArg = null;
							// on exit we have the x1 calculation precondition
						} else {
							calculator.setDisplayFieldText(Double.toString(operationResult));
							// on exit we have the x3 calculation precondition
						}
					}
				} else {
					firstArg = null;
					secondArg = null;
					operationResult = null;
					// on exit we have the x1 calculation precondition
				}
			}
			break;

		} // end switch

	}

}
