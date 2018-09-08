package tax;

public class Tax implements Taxable {

    final static double STUDENT_DEDUCTION = 300.00;

    @Override
    public double calcTax(double grossIncome, int dependents) throws IllegalArgumentException {
        if (grossIncome < 0) {
            throw new IllegalArgumentException("Gross income can't be negative");
        }
        return (grossIncome * 0.33 - dependents * 100);
    }

    @Override
    public double applyStudentDeduction(double taxAmount, int numOfStudents) {

        return taxAmount - STUDENT_DEDUCTION * numOfStudents;
    }

}
