import javax.swing.*;

public class GUIBankMenu extends MyBankGUI{
    public GUIBankMenu() {
        super();
    }

    protected static void createBankMenu(JPanel panel) {

        // create account or cancel account
        openAccount = new JButton("Create Bank Account");
        panel.add(openAccount);
        closeAccount = new JButton("Cancel Bank Account");
        panel.add(closeAccount);
        backToLogin = new JButton("Logout");
        panel.add(backToLogin);

        p3 = panel;

    }



}
