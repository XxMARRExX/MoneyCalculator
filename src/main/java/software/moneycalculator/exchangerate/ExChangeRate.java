package software.moneycalculator.exchangerate;

import software.moneycalculator.currency.Currency;

import java.time.LocalDate;

public record ExChangeRate(Currency from, Currency to, LocalDate date, double rate) {
}
