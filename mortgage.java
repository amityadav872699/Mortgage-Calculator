// importing packages
import java.text.NumberFormat;
import java.util.Scanner;

// class name and main() method
public class MortgageCalculator {
    public static void main(String[] args) {

        long principal = (long) readNumbers("Principal : ", 1_000, 1_000_000);
        float annualInterest = (float) readNumbers("Annual Interest Rate : ", 1, 30);
        int years = (int) readNumbers("Period (years) : ", 1, 12);

        double mortgage = calculateMortgage(principal, annualInterest, years);

        // converting numerical to currency
        String mortgageFormat = NumberFormat.getCurrencyInstance().format(mortgage);

        // printing output
        System.out.println("Mortgage Value = " + mortgageFormat);
    }

    // method to read numbers
    public static double readNumbers(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value > min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
            scanner.close();
        }
        return value;
    }

    // method to calculate mortgage
    public static double calculateMortgage(long principal, float annualInterest, int years) {
        float monthlyInterest = annualInterest / 100 / 12;
        int numberOfPayments = years * 12;
        // logic to calculate mortgage
        return (principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }
}