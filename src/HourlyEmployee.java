import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HourlyEmployee extends Employee {
    protected double wage;
    protected double hour;
    protected double overtimeHours;

    public HourlyEmployee( String firstName, String lastName, String socialSecurityNumber,
                           double wage, double hour)
    {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hour = hour;
        this.overtimeHours = 0;
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
    //--------------------------------------------------------------------------------------
    public void setOvertimeHours(double overtimeHours)
    {
        if(hour > 40)
        {
            this.overtimeHours = hour - 40;
        }
        else
        {
            this.overtimeHours = 0;
        }
    }
    public double getOvertimeHours()
    {
        return this.overtimeHours;
    }


    public double getPaymentAmount()
    {
        if(overtimeHours > 0){
            return (wage * hour) + ((wage * 1.5) * overtimeHours);
        }
        else{
            return wage * hour;
        }

    }

    @Override
    public void writeToFile(){

        try(PrintWriter out = new PrintWriter( new FileWriter("HourLy Employee Pay Stub.txt", true))){
            out.println("Employee Name: " + firstName + " " + lastName + "\n" +
                    "Social Security Number: " + socialSecurityNumber + "\n" +
                    " Wage: $" + wage + "\n" +
                    " Hours Worked: " + hour  +
                    "Overtime Hours: " + overtimeHours + "\n" +
                    " Payment Amount: $" + getPaymentAmount());

        }
        catch(IOException e){
            System.out.println("Error writing to file");
        }

    }

}
