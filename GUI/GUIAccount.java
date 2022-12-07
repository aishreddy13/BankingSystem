import javax.swing.*;

public class GUIAccount extends MyBankGUI{
    protected GUIAccount() {
        super();
    }

    protected static void createAccount(JPanel panel) {
        JLabel msg = new JLabel("Hello! Welcome to your new bank account: ");
        panel.add(msg);
        withdraw = new JButton("Withdraw Money");
        panel.add(withdraw);
        deposit = new JButton("Deposit Money");
        panel.add(deposit);
        viewHistory = new JButton("View Transaction History");
        panel.add(viewHistory);
        viewBalance = new JButton("View current Balance");
        panel.add(viewBalance);
        exchangeCurrency = new JButton("Exchange Currency");
        panel.add(exchangeCurrency);
        requestLoan = new JButton("Request Loan");
        panel.add(requestLoan);
        backToMainMenu = new JButton("Back to Main Menu");
        panel.add(backToMainMenu);

        p4 = panel;
    }

    protected static void cancelAccount(JPanel panel) {
        JLabel msg = new JLabel("Hello! We are sorry to see you go, please let us know how we can improve by leaving your feedback.");
        panel.add(msg);

        // create customer feedback
        JLabel feedback = new JLabel("Customer Feedback");
        panel.add(feedback);

        JTextField feedbackbox = new JTextField(20);
        feedbackbox.setBounds(100, 20, 165, 25);
        panel.add(feedbackbox);

        submitFeedback = new JButton("Submit");
        panel.add(submitFeedback);

        p5 = panel;

    }

}
