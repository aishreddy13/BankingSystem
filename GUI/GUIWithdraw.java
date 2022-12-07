import javax.swing.*;

public class GUIWithdraw extends MyBankGUI{
    protected GUIWithdraw() {
        super();
    }

    protected static void withdraw(JPanel panel) {
        withdrawLabel = new JLabel("Withdraw");
        withdrawLabel.setBounds(10, 20, 80, 25);
        panel.add(withdrawLabel);

        withdrawText = new JTextField(20);
        withdrawText.setBounds(60, 20, 50, 25);
        panel.add(withdrawText);

        confirmWithdraw = new JButton("Confirm");
        panel.add(confirmWithdraw);

        backToBankMenu1 = new JButton("Back To Menu");
        panel.add(backToBankMenu1);

        p6 = panel;
    }
}
