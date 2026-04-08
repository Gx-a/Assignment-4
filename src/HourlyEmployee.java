public class HourlyEmployee {
    protected double wage;
    protected double hour;

    public HourlyEmployee(double wage, double hour)
    {
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
