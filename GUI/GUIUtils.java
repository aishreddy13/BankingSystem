import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class GUIUtils extends MyBankGUI{
    protected GUIUtils() {
        super();
    }

    protected static Double getAmount(JTextField amount) {
        String s = amount.getText();
        Double d = Double.parseDouble(s);
        return d;
    }

    protected static void updateBalanceLabel() {
        balanceLabel.setText("Balance: " + account.getBalance());
    }
}
