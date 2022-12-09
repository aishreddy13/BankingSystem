import javax.swing.*;

public class GUICheckingSaving extends MyBankGUI{
    protected GUICheckingSaving() {
        super();
    }

    protected static void chooseAccountType(JPanel panel) {
        checkingAccount = new JButton("Checking Account");
        savingAccount = new JButton("Saving Account");
        panel.add(checkingAccount);
        panel.add(savingAccount);

        p11 = panel;
    }
}
