package software.moneycalculator.command;

import software.moneycalculator.currency.Currency;
import software.moneycalculator.currency.CurrencyDialog;
import software.moneycalculator.exchangerate.ExChangeRate;
import software.moneycalculator.exchangerate.ExchangeRateLoader;
import software.moneycalculator.money.Money;
import software.moneycalculator.money.MoneyDialog;
import software.moneycalculator.money.MoneyDisplay;

import java.io.IOException;
import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class ExchangeMoneyCommand implements Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() throws IOException {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();
        ExChangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money result = new Money(money.amount() * exchangeRate.rate(), currency);
        moneyDisplay.show(result);
    }
}
