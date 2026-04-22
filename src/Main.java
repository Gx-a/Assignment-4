/*  Akein Bantin #2401011023
    Zhane Tomlin #2401010939
    Chevar Prince #2401010646
    Ryan Brown #
    Georgia Black Golding #1817002195
*/
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /* Create objects */
        SalariedEmployee emp1 = new SalariedEmployee( "John", "Wick", "123", 8);
        HourlyEmployee emp2 = new HourlyEmployee("Will", "Smith", "456", 20, 45);
        CommissionEmployee emp3 = new CommissionEmployee("Mark", "Golding", "789", 10000, 0.1);
        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee("Lisa","Hanna", "321", 50000, 0.05);

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

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("payroll_data.dat")
            );
            out.writeObject(list);
            out.close();
            System.out.println("Data saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("payroll_data.dat")
            );
            ArrayList<Payable> loadedList = (ArrayList<Payable>) in.readObject();
            in.close();

            System.out.println("Loaded Data:");
            for (Payable p : loadedList) {
                System.out.println("Payment: " + p.getPaymentAmount());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
