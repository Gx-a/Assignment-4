public class HourlyEmployee extends Employee {
    protected double wage;
    protected double hour;

    public HourlyEmployee( String firstName, String lastName, String socialSecurityNumber,
                           Payable payable, double wage, double hour)
    {
        super(firstName, lastName, socialSecurityNumber, payable);
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
}
