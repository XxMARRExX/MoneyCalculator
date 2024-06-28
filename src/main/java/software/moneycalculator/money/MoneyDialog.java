package software.moneycalculator.money;

import software.moneycalculator.currency.Currency;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
