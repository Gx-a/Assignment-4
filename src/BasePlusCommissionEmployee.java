public class BasePlusCommissionEmployee {
    protected double baseSalary;

    public BasePlusCommissionEmployee( double baseSalary)
    {
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

}
