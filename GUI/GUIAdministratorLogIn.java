import javax.swing.*;

public class GUIAdministratorLogIn extends MyBankGUI {
    protected GUIAdministratorLogIn() {
        super();
    }

    protected static void createAdministratorLogIn(JPanel panel) {
        JButton customers = new JButton("Customers");
        JButton reports = new JButton("Reports");
        administratorBack = new JButton("Back to Login Page");

        panel.add(customers);
        panel.add(reports);
        panel.add(administratorBack);
    }

}
