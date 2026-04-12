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

}
