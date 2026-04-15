import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalariedEmployee extends Employee {
    protected double weeklySalary;

    public SalariedEmployee(double weeklySalary, String firstName, String lastName, String socialSecurityNumber){

        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }
    //--------------------------------------------------------------------------------------

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
    public double getWeeklySalary()
    {
        return this.weeklySalary;
    }
    //--------------------------------------------------------------------------------------


    public double getPaymentAmount()
    {
        return weeklySalary;
    }



    @Override
    public void writeToFile(){

        try(PrintWriter out = new PrintWriter( new FileWriter("Salaried Employee Pay Stub.txt", true))){
            out.println();

        }
        catch(IOException e){
            System.out.println("Error writing to file");
        }

    }
}
