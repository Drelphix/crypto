package by.watcher.crypto.service;

import by.watcher.crypto.model.currency.Currency;

import java.util.List;

public interface CoinLoreService {

    long getCurrencyCount();
    List<Currency> getCurrency();

}
