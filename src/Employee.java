public abstract class Employee {
    protected String firstName;
    protected String lastName;
    protected String socialSecurityNumber;


    public Employee( String firstName, String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    //--------------------------------------------------------------------------------------
    public void SetFirstName(String firstName)
    {
        this.firstName = firstName;
    }
   public String GetFirstName()
   {
        return this.firstName;
    }
    //--------------------------------------------------------------------------------------
    public void SetLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String GetLastName() {
        return this.lastName;
    }
    //--------------------------------------------------------------------------------------
    public void SetSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public String GetSocialSecurityNumber()
    {
        return this.socialSecurityNumber;
    }
    //--------------------------------------------------------------------------------------
    public void SetHours(double hours)
    {
        this.hours = hours;
    }
    public double GetHours()
    {
        return this.hours;
    }
    //--------------------------------------------------------------------------------------
    public double SalariedEmployee()
    {
        return ;
    }
    //--------------------------------------------------------------------------------------

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
