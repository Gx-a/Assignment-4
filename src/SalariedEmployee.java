import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalariedEmployee extends Employee {
    protected double weeklySalary;
    protected double weeksWorked;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeksWorked){

        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = 0;
        this.weeksWorked = weeksWorked;
    }
    //--------------------------------------------------------------------------------------

    public void setWeeklySalary(double weeklySalary){
        this.weeklySalary = 40000;
    }
    public double getWeeklySalary()
    {
        return this.weeklySalary;
    }
    public void setWeeksWorked(double weeksWorked) throws InvalidSalaryException {
        if (weeksWorked <= 0) {
            throw new InvalidSalaryException("Weeks worked cannot be negative!");
        }
        this.weeksWorked = weeksWorked;
    }
    public double getWeeksWorked(){
        return weeksWorked;
    }
    //--------------------------------------------------------------------------------------


    public double getPaymentAmount()
    {
        return weeklySalary * weeksWorked;
    }



    @Override
    public void writeToFile(){

        try(PrintWriter out = new PrintWriter( new FileWriter("Salaried Employee Pay Stub.txt", true))){
            out.println("Employee Name: " + firstName + " " + lastName + "\n" +
                    "Social Security Number: " + socialSecurityNumber + "\n" +
                    " Weekly Salary: $" + weeklySalary + "\n" +
                    " Weeks Worked: " + weeksWorked +
                    " Payment Amount: $" + getPaymentAmount());

        }
        catch(IOException e){
            System.out.println("Error writing to file");
        }

    }

    private class InvalidSalaryException extends Throwable {
        public InvalidSalaryException(String s) {
        }
    }
}
