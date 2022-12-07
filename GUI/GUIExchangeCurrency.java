import javax.swing.*;

public class GUIExchangeCurrency extends MyBankGUI {
    protected GUIExchangeCurrency() {
        super();
    }

    protected static void convertCurrency(JPanel panel) {
        toPound = new JButton("Dollar to Pound");
        panel.add(toPound);

        toEuro = new JButton("Dollar to Euro");
        panel.add(toEuro);

        toYuan = new JButton("Dollar to Yuan");
        panel.add(toYuan);

        p9 = panel;
    }
}
