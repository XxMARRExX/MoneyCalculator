package software.moneycalculator.exchangerate;

import software.moneycalculator.currency.Currency;

import java.io.IOException;

public interface ExchangeRateLoader {
    ExChangeRate load(Currency from, Currency to) throws IOException;
}
