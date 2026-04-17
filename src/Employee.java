import java.io.Serializable;

public abstract class Employee implements Payable, Serializable {
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



    public double getPaymentAmount(){
        return 0;
    }


    public void writeToFile(){

    }

    public String getFullName() {
        return "";
    }
}
