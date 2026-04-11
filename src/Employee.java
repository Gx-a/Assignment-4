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




}
