import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HourlyEmployee extends Employee {
    protected double wage;
    protected double hour;

    public HourlyEmployee( String firstName, String lastName, String socialSecurityNumber,
                           double wage, double hour)
    {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hour = hour;
    }
    //--------------------------------------------------------------------------------------
    public  void setWage(double wage)
    {
        this.wage = wage;
    }
    public double getWage() {
        return wage;
    }
    //--------------------------------------------------------------------------------------
    public void setHour(double hour)
    {
        this.hour = hour;
    }
    public double getHour()
    {
        return hour;
    }


    public double getPaymentAmount()
    {
        double hourlySalary;
        return hourlySalary = wage * hour;
    }

    @Override
    public void writeToFile(){

        try(PrintWriter out = new PrintWriter( new FileWriter("HourLy Employee Pay Stub.txt", true))){
            out.println();

        }
        catch(IOException e){
            System.out.println("Error writing to file");
        }

    }

}
