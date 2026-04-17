import java.io.*;
import java.util.ArrayList;

public class PayrollFileManager {
    private static final String FILE_NAME = "payroll_data.dat";

    //Save Method
    public static void saveData(ArrayList<Payable> list) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(FILE_NAME));

            out.writeObject(list);
            out.close();

            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Load Method
    public static ArrayList<Payable> loadData() {
        ArrayList<Payable> list = new ArrayList<>();

        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(FILE_NAME));

            list = (ArrayList<Payable>) in.readObject();
            in.close();

            System.out.println("Data loaded successfully!");

        } catch (IOException e) {
            System.out.println("No previous data found.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}
