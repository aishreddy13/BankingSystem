import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUIViewTransactions extends MyBankGUI {
    protected GUIViewTransactions() {
        super();
    }

    protected static void viewTransactions(JScrollPane pane) {

        JTable tbl = new JTable();
        Object[] columns = {"Transaction Type", "Amount", "Remaining Balance"};
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);
        tbl.setModel(model);
        tbl.setRowHeight(30);
        tbl.setAutoCreateRowSorter(true);

        pane = new JScrollPane();

        Object[] row = new Object[4];

        confirmWithdraw.addActionListener(action -> {
            row[0] = withdrawLabel.getText();
            row[1] = withdrawText.getText();
            row[2] = balanceLabel.getText();

            model.addRow(row);
        });

        confirmDeposit.addActionListener(action -> {
            row[0] = depositLabel.getText();
            row[1] = depositText.getText();
            row[2] = balanceLabel.getText();

            model.addRow(row);
        });

        loanSubmit.addActionListener(action -> {
            row[0] = loanLabel.getText();
            row[1] = loanText.getText();
            row[2] = balanceLabel.getText();

            model.addRow(row);
        });

        pane.add(tbl);

//        historyBack = new JButton("Back to Main Menu");
//        panel.add(historyBack);

        p20 = pane;

    }
}
