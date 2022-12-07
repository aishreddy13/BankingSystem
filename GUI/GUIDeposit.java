import javax.swing.*;

public class GUIDeposit extends MyBankGUI{
    protected GUIDeposit() {
        super();
    }

    protected static void deposit(JPanel panel) {
        depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(10, 20, 80, 25);
        panel.add(depositLabel);

        depositText = new JTextField(20);
        depositText.setBounds(60, 20, 50, 25);
        panel.add(depositText);

        confirmDeposit = new JButton("Confirm");
        panel.add(confirmDeposit);

        backToBankMenu2 = new JButton("Back To Menu");
        panel.add(backToBankMenu2);

        p8 = panel;
    }
}
