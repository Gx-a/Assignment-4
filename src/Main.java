import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /* Create objects */
        SalariedEmployee emp1 = new SalariedEmployee(800,"John", "Wick", "123");
        HourlyEmployee emp2 = new HourlyEmployee("Will", "Smith", "456", 20, 45);
        CommissionEmployee emp3 = new CommissionEmployee("Mark", "Golding", "789", 10000, 0.1);
        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee(100000,"Lisa","Hanna", "321", 50000, 0.05);

        Invoice inv1 = new Invoice("A101", "P001", 100, 120);

        // Store in list
        ArrayList<Payable> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(inv1);

        // Display payments
        for (Payable p : list) {
            System.out.println("Payment: " + p.getPaymentAmount());
        }
    }
}
