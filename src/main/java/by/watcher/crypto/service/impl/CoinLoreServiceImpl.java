package by.watcher.crypto.service.impl;

import by.watcher.crypto.exception.ApiException;
import by.watcher.crypto.message.Message;
import by.watcher.crypto.model.entities.CoinLoreCurrency;
import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.service.CoinLoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinLoreServiceImpl implements CoinLoreService {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String COIN_LORE_API_LINK = "https://api.coinlore.net/api/ticker/?id=";

    @Override
    public CoinLoreCurrency getCurrencyById(long id) {
        return getCoinLoreCurrencyById(id);
    }

    @Override
    public List<CoinLoreCurrency> getAllCurrencyFromList(List<Currency> currencyList) throws ApiException {
        List<CoinLoreCurrency> coinLoreCurrencies = new ArrayList<>();
        try {
            for (Currency currency : currencyList) {
                CoinLoreCurrency loreCurrency = getCoinLoreCurrencyById(currency.getId());
                coinLoreCurrencies.add(loreCurrency);
            }
        } catch (NullPointerException | ResourceAccessException e) {
            LOGGER.error(Message.GET_API_INFO_ERROR, e);
            throw new ApiException(Message.GET_API_INFO_ERROR, e);
        }
        return coinLoreCurrencies;
    }

    private CoinLoreCurrency getCoinLoreCurrencyById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        CoinLoreCurrency[] currency = restTemplate.getForObject(COIN_LORE_API_LINK + id, CoinLoreCurrency[].class);
        return currency[0];
    }
}
