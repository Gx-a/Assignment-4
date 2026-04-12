public class CommissionEmployee extends Employee{
    protected  double grossSales;
    protected double commissionRate;

    public CommissionEmployee( String firstName, String lastName, String socialSecurityNumber, double grossSales,  double commissionRate )
    {
        super(firstName, lastName, socialSecurityNumber);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    //--------------------------------------------------------------------------------------
    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }
    public double getGrossSales() {
        return grossSales;
    }
    //--------------------------------------------------------------------------------------
    public void setCommissionRate(double commissionRate)
    {
        this.commissionRate = commissionRate;
    }
    public double getCommissionRate()
    {
        return commissionRate;
    }


    @Override
    public double getPaymentAmount(){
        return 0;
    }

    @Override
    public void writeToFile(){}


}

