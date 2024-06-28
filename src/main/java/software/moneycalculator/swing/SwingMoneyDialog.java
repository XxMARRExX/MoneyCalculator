package software.moneycalculator.swing;

import software.moneycalculator.currency.Currency;
import software.moneycalculator.currency.CurrencyDialog;
import software.moneycalculator.money.Money;
import software.moneycalculator.money.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private final JTextField amountField;
    private CurrencyDialog currencyDialog;

    public SwingMoneyDialog(JTextField textField) {
        this.setLayout(new FlowLayout());
        this.amountField = textField;
    }

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        add(createCurrencyDialog(currencies));
        return this;
    }

    private Component createCurrencyDialog(List<Currency> currencies) {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog("From:");
        dialog.define(currencies);
        this.currencyDialog = dialog;
        return dialog;
    }

    @Override
    public Money get() {
        return new Money(toDouble(amountField.getText()), currencyDialog.get());
    }

    private double toDouble(String text) {
        return Double.parseDouble(text);
    }
}
