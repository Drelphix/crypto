package by.watcher.crypto.service.impl;

import by.watcher.crypto.model.entities.CoinLoreCurrency;
import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.service.CoinLoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoinLoreServiceImpl implements CoinLoreService {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String COIN_LORE_API_LINK= "https://api.coinlore.net/api/ticker/?id=";

    @Override
    public CoinLoreCurrency getCurrencyById(long id) {
        return getCoinLoreCurrencyById(id);
    }

    @Override
    public List<CoinLoreCurrency> getAllCurrencyFromList(List<Currency> currencyList) {
        List<CoinLoreCurrency> coinLoreCurrencies = new ArrayList<>();
            for (Currency currency : currencyList) {
                CoinLoreCurrency loreCurrency = getCoinLoreCurrencyById(currency.getId());
                coinLoreCurrencies.add(loreCurrency);
            }
            return coinLoreCurrencies;
    }

    private CoinLoreCurrency getCoinLoreCurrencyById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        CoinLoreCurrency[] currency = null;
        currency = restTemplate.getForObject(COIN_LORE_API_LINK+id,CoinLoreCurrency[].class);
        return currency[0];
    }
}
