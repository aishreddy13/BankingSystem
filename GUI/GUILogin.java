import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogin extends MyBankGUI{
    protected GUILogin() {
        super();
    }

    protected static void createLogin(JPanel panel) {

        // Create user label
        userLabel = new JLabel("User");
        userLabel.setBounds(110, 140, 80, 25);
        panel.add(userLabel);

        // create text field for user to enter username
        userText = new JTextField(20);
        userText.setBounds(200, 140, 165, 25);
        panel.add(userText);

        // create password label
        passwordLabel = new JLabel("Password");
        userLabel.setBounds(110, 180, 80, 25);
        panel.add(passwordLabel);

        // create password text field
        passText = new JPasswordField(20);
        passText.setBounds(200, 180, 165, 25);
        panel.add(passText);

        // Create the log in and register buttons
        logIn = new JButton("User Login");
        register = new JButton("Register");
        administratorLogIn = new JButton("Administrator Login");

        // Add each button to the panel
        panel.add(logIn);
        panel.add(register);
        panel.add(administratorLogIn);

        // Connect button action to event - each event is an object of a class
        loginListener login = new loginListener();
        logIn.addActionListener(login);
        registerListener reg = new registerListener();
        register.addActionListener(reg);

        // Create the panel to place the buttons on
        // panel.setLayout(null);
        p1 = panel;
    }

    // loginListener. When click, print clicked.
    protected static class loginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Log in button clicked");
        }
    }

    // registerListener. When click, print clicked.
    protected static class registerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Register button clicked");
        }
    }

}
