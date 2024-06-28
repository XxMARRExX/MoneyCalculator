package software.moneycalculator.swing;

import software.moneycalculator.command.Command;
import software.moneycalculator.command.ExchangeMoneyCommand;
import software.moneycalculator.currency.Currency;
import software.moneycalculator.fixerws.FixerCurrencyLoader;
import software.moneycalculator.fixerws.FixerExchangeRateLoader;

import java.net.MalformedURLException;
import java.util.List;

public class Main {
    public static String date;

    public static void main(String[] args) throws MalformedURLException {
        DateFrame dateFrame = new DateFrame();
        dateFrame.setVisible(true);
        while (date == null) {
            date = dateFrame.getDate();
        }
        dateFrame.setVisible(false);
        MainFrame mainFrame = new MainFrame();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                mainFrame.moneyDialog().define(currencies),
                mainFrame.currencyDialog().define(currencies),
                new FixerExchangeRateLoader(date),
                mainFrame.moneyDisplay());
        mainFrame.add("exchange money", command);
        mainFrame.setVisible(true);
    }
}
