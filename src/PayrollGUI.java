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

        setTitle("Payroll System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Table
        model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new String[]{"Type", "First Name", "Last Name", "Payment"});

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        //Button panel
        JPanel panel = new JPanel();

        JButton btnAdd = new JButton("Add Employee");
        JButton btnRemove = new JButton("Remove Employee");
        JButton btnPayStub = new JButton("Generate Pay Stub");

        panel.add(btnAdd);
        panel.add(btnRemove);
        panel.add(btnPayStub);

        add(panel, BorderLayout.SOUTH);

        //Button Actions
        btnAdd.addActionListener(e -> addRecord());
        btnRemove.addActionListener(e -> removeRecord());
        btnPayStub.addActionListener(e -> generatePayStub());

        setVisible(true);
    }

    private void generatePayStub() {
    }

    private void removeRecord() {

    }

    private void addRecord() {

    }

}
