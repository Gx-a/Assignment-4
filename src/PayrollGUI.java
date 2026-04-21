/*  Akein Bantin #2401011023
    Zhane Tomlin #2401010939
    Chevar Prince #
    Ryan Brown #
    Georgia Black Golding #1817002195
*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PayrollGUI extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<Payable> payrollList;

    public PayrollGUI() {
        payrollList = new ArrayList<>();
        //Setup window settings
        setTitle("Payroll System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Initialize table model
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
                "Salary", "First Name", "Last Name", "Payment"
        });

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons
        JPanel inputPanel = new JPanel();

        JButton btnAdd = new JButton("Add Employee");
        JButton btnRemove = new JButton("Remove Employee");
        JButton btnPayStub = new JButton("Generate Pay Stub");

        inputPanel.add(btnAdd);
        inputPanel.add(btnRemove);
        inputPanel.add(btnPayStub);

        add(inputPanel, BorderLayout.SOUTH);

        // Actions
        btnAdd.addActionListener(e -> addRecord());
        btnRemove.addActionListener(e -> removeRecord());
        btnPayStub.addActionListener(e -> generatePayStub());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Generator button
    private void generatePayStub() {
        try {
            for (Payable p : payrollList) {
                p.writeToFile();
            }
            JOptionPane.showMessageDialog(this, "Pay stubs generated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error writing file!");
        }
    }

    // Remove record button
    private void removeRecord() {
        int row = table.getSelectedRow();

        if (row >= 0) {
            payrollList.remove(row);
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Select a row first!");
        }
    }

    // Add record button
    private void addRecord() {
        try {
            // Dropdown box for the type of salaried employee
            JComboBox<String> typeBox = new JComboBox<>(
                    new String[]{"Salaried", "Hourly", "Commissioned", "Base Commissioned"}
            );

            int option = JOptionPane.showConfirmDialog(
                    this,
                    typeBox,
                    "Select Employee Type",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (option != JOptionPane.OK_OPTION) return;

            String type = (String) typeBox.getSelectedItem();

            String firstName = JOptionPane.showInputDialog("First Name: ");
            String lastName = JOptionPane.showInputDialog("Last Name: ");
            String SocialSecurityNumber = JOptionPane.showInputDialog("Social Security Number: ");

//          Salaried Employee
            if (type.equalsIgnoreCase("Salaried")) {

                double WeeksWorked = Double.parseDouble(
                        JOptionPane.showInputDialog("Weeks worked: ")
                );

                if (WeeksWorked < 0)
                    throw new InvalidSalaryException("work weeks cannot be negative!");

                Payable emp = new SalariedEmployee(firstName, lastName, SocialSecurityNumber, WeeksWorked);

                payrollList.add(emp);

                model.addRow(new Object[]{
                        "Salaried", firstName, lastName, emp.getPaymentAmount()
                });

//          Hourly Employee
            } else if (type.equalsIgnoreCase("Hourly")) {

                double wage = Double.parseDouble(
                        JOptionPane.showInputDialog("Wage:")
                );
                double hours = Double.parseDouble(
                        JOptionPane.showInputDialog("Hours:")
                );

                if (wage < 0 || hours < 0)
                    throw new InvalidSalaryException("Invalid values!");

                Payable emp = new HourlyEmployee(firstName, lastName, "N/A", wage, hours);

                payrollList.add(emp);

                model.addRow(new Object[]{
                        "Hourly", firstName, lastName, emp.getPaymentAmount()
                });

//          Commissioned Employee
            } else if (type.equalsIgnoreCase("Commissioned")) {

                double grossSales = Double.parseDouble(JOptionPane.showInputDialog("Gross Salers: $"));
                JComboBox<String> CRTypeBox = new JComboBox<>(new String[]{"0.1","0.2","0.3"});

                int choice = JOptionPane.showConfirmDialog(
                        null,
                        CRTypeBox,
                        "Select Commission Rate",
                        JOptionPane.OK_CANCEL_OPTION
                );

                double commissionRate = Double.parseDouble((String) CRTypeBox.getSelectedItem());


                if(grossSales < 0){
                    throw new InvalidSalaryException("Invalid values!");}

                Payable emp = new CommissionEmployee(firstName, lastName, SocialSecurityNumber, grossSales, commissionRate);

                payrollList.add(emp);
                model.addRow(new Object[]{"Commissioned", firstName, lastName, emp.getPaymentAmount()});

//          Base Commissioned Employee
            } else  if (type.equalsIgnoreCase("Base Commissioned")) {
                double grossSales = Double.parseDouble(JOptionPane.showInputDialog("Gross Salers: $"));
                JComboBox<String> CRTypeBox = new JComboBox<>(new String[]{"0.1","0.2","0.3"});

                int choice = JOptionPane.showConfirmDialog(
                        null,
                        CRTypeBox,
                        "Select Commission Rate",
                        JOptionPane.OK_CANCEL_OPTION
                );

                double commissionRate = Double.parseDouble((String) CRTypeBox.getSelectedItem());

                if(grossSales < 0){
                    throw new InvalidSalaryException("Invalid values!");}

                Payable emp = new BasePlusCommissionEmployee(firstName, lastName, SocialSecurityNumber, grossSales, commissionRate);
                payrollList.add(emp);
                model.addRow(new Object[]{"Base Commissioned", firstName, lastName, emp.getPaymentAmount()});

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number!");
        } catch (InvalidSalaryException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new PayrollGUI();
    }
}