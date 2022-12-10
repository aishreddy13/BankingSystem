package currency.conversion;

import currency.Currency;
import exceptions.ConversionRateNotFoundException;
import exceptions.DBQueryExecutionException;
import persistence.DbCurrencyExchangeRateFetcher;

public class CurrencyConversionHelper {

    static DbCurrencyExchangeRateFetcher dbCurrencyExchangeRateFetcher = new DbCurrencyExchangeRateFetcher();
    public static float convertCurrency(String inputCurName , String outCurrencyName, float value ) throws DBQueryExecutionException, ConversionRateNotFoundException {
        float exchangeRate=dbCurrencyExchangeRateFetcher.fetchExchangeRate(inputCurName,outCurrencyName);
        return value*exchangeRate;
    }

    public static Currency convertCurrency(Currency inputCurrency, String outCurrencyName) throws DBQueryExecutionException, ConversionRateNotFoundException {
        float newCurrencyValue = convertCurrency(inputCurrency.getName(),outCurrencyName,inputCurrency.getQuantity());
        return new Currency(outCurrencyName,newCurrencyValue);
    }


    public static void main(String[] args) throws DBQueryExecutionException, ConversionRateNotFoundException {
        Currency usd = new Currency("USD","USD",10);
        Currency inr = convertCurrency(usd,"INR");
        System.out.println(inr.getQuantity());
    }
}
