import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BasePlusCommissionEmployee extends CommissionEmployee{
    protected double baseSalary;

    public BasePlusCommissionEmployee( double baseSalary, String firstName, String lastName, String socialSecurityNumber, double grossSales,  double commissionRate )
    {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        this.baseSalary = baseSalary;
    }

    //--------------------------------------------------------------------------------------
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public double getBaseSalary()
    {
        return baseSalary;
    }
    //--------------------------------------------------------------------------------------

    @Override
    public double getPaymentAmount(){

        return baseSalary + (grossSales * commissionRate);
    }

    @Override
    public void writeToFile(){

        try(PrintWriter out = new PrintWriter( new FileWriter("Commission Employee Pay Stub.txt", true))){
            out.println("Employee Name: " + firstName + " " + lastName + "\n" +
                    "Social Security Number: " + socialSecurityNumber + "\n" +
                    "Base Salary: " + baseSalary + "\n" +
                    " Gross Sales: " + grossSales + "\n" +
                    " Commission Rate: " + commissionRate + "\n" +
                    " Payment Amount: " + getPaymentAmount());

        }
        catch(IOException e){
            System.out.println("Error writing to file");
        }

    }
}
