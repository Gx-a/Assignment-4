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
}
