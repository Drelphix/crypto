package by.watcher.crypto.service;

import by.watcher.crypto.model.entities.CoinLoreCurrency;
import by.watcher.crypto.model.entities.Currency;

import java.util.List;

public interface CoinLoreService {

    CoinLoreCurrency getCurrencyById(long id);

    List<CoinLoreCurrency> getAllCurrencyFromList(List<Currency> currencyList);


}
