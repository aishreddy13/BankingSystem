import javax.swing.*;

public class GUIRequestLoan extends MyBankGUI{
    protected GUIRequestLoan() {
        super();
    }

    protected static void requestLoan(JPanel panel) {
        loanLabel = new JLabel("Requested Loan Amount: ");
        loanLabel.setBounds(10, 20, 80, 25);
        panel.add(loanLabel);

        loanText = new JTextField(20);
        loanText.setBounds(60, 20, 50, 25);
        panel.add(loanText);

        loanSubmit = new JButton("Submit");
        panel.add(loanSubmit);
    }
}
