package by.watcher.crypto.service;

import by.watcher.crypto.model.entities.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {
    void addCurrency(Currency currency);

    List<Currency> getAll();

    Optional<Currency> getCurrencyById(long id);

    Optional<Currency> findCurrencyBySymbol(String symbol);
}
