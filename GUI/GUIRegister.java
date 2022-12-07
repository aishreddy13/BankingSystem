import javax.swing.*;

public class GUIRegister extends MyBankGUI{
    protected GUIRegister() {
        super();
    }

    protected static void createRegister(JPanel panel) {
        // enter first name
        JLabel firstName = new JLabel("First Name");
        firstName.setBounds(10, 20, 80, 25);
        panel.add(firstName);

        firstNameText = new JTextField(20);
        firstNameText.setBounds(100, 20, 165, 25);
        panel.add(firstNameText);

        // enter last name
        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(10, 20, 80, 25);
        panel.add(lastName);

        lastNameText = new JTextField(20);
        lastNameText.setBounds(100, 20, 165, 25);
        panel.add(lastNameText);

        // enter email
        JLabel email = new JLabel("Email");
        email.setBounds(10, 20, 80, 25);
        panel.add(email);

        emailText = new JTextField(20);
        emailText.setBounds(100, 20, 165, 25);
        panel.add(emailText);

        // enter user name
        JLabel userName = new JLabel("User Name");
        userName.setBounds(10, 20, 80, 25);
        panel.add(userName);

        userNameText = new JTextField(20);
        userNameText.setBounds(100, 20, 165, 25);
        panel.add(userNameText);

        // enter password
        // create password label
        passwordLabel = new JLabel("Password");
        userLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // create password text field
        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // submit button
        submitRegister = new JButton("Submit");
        panel.add(submitRegister);

        p2 = panel;
    }
}
