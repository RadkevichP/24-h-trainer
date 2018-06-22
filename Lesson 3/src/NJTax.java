
public class NJTax extends Tax {
	// Adjust caclTax for NJ
	double adjustForStudents (double stateTax) {
		double adjustedTax = stateTax - 500;
		return adjustedTax;
	}
}
