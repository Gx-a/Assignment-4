public class CommissionEmployee {
    protected  double grossSales;
    protected double commissionRate;

    public CommissionEmployee( double grossSales,  double commissionRate )
    {
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
}

