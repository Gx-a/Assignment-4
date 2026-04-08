public class SalariedEmployee {
    protected double weeklySalary;

    public SalariedEmployee(double weeklySalary){
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
}
