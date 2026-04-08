public abstract class Employee {
    protected String firstName;
    protected String lastName;
    protected int socialSecurityNumber;


    public Employee( String firstName, String lastName, int socialSecurityNumber,
                    double weeklySalary, double hourlySalary, double wage, double hours){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void SetFirstName(String firstName)
    {
        this.firstName = firstName;
    }
   public String GetfirstName()
   {
        return this.firstName;
    }
    public void SetlastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String GetlastName() {
        return this.lastName;
    }
    public void socialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public int GetsocialSecurityNumber()
    {
        return this.socialSecurityNumber;
    }
    public void hours(double hours)
    {
        this.hours = hours;
    }
    public double Gethours()
    {
        return this.hours;
    }

        public double SalariedEmployee()
        {
            return ;
        }
        public double HourlyEmployee()
        {
            double hourlySalary = wage * hours;
          return hourlySalary;
        }


        @Override
        public void writeToFile()
        {
        System.out.println("Employee  Name : " + firstName + " " + lastName);
        System.out.println("Employee Social Security Number : " + socialSecurityNumber);
        System.out.println("Salary : " + );
        }
}
