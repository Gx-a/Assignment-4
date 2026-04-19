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
                    new String[]{"Salaried", "Hourly"}
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

            if (type.equalsIgnoreCase("Salaried")) {

                double salary = Double.parseDouble(
                        JOptionPane.showInputDialog("Salary: ")
                );

                if (salary < 0)
                    throw new InvalidSalaryException("Salary cannot be negative!");

                Payable emp = new SalariedEmployee(firstName, lastName, "N/A", salary);

                payrollList.add(emp);

                model.addRow(new Object[]{
                        "Salaried", firstName, lastName, emp.getPaymentAmount()
                });

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