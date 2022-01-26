package by.watcher.crypto.validator;

import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyValidator {
    @Autowired
    CurrencyService currencyService;

    public boolean validateSymbol(String symbol) {
        List<Currency> currencyList = currencyService.getAll();
        for (Currency currency : currencyList) {
            if (currency.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }
}
