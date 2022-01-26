package by.watcher.crypto.config;

import by.watcher.crypto.exception.ApiException;
import by.watcher.crypto.model.entities.CoinLoreCurrency;
import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.model.entities.Price;
import by.watcher.crypto.service.CoinLoreService;
import by.watcher.crypto.service.CurrencyService;
import by.watcher.crypto.service.PriceService;
import by.watcher.crypto.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@Component
public class ScheduleTask {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private CoinLoreService coinLoreService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private UserService userService;

    @Scheduled(fixedRate = 60000)
    public void getCoinLoreInfo() {
        List<Currency> currencies = currencyService.getAll();
        try {
            List<CoinLoreCurrency> coinLoreCurrencies = coinLoreService.getAllCurrencyFromList(currencies);
            List<Price> prices = new ArrayList<>();
            for (int i = 0; i < currencies.size(); i++) {
                long id = coinLoreCurrencies.get(i).getId();
                double price = coinLoreCurrencies.get(i).getPriceUsd();
                prices.add(new Price(id, price));
            }
            priceService.saveAll(prices);
        } catch (ApiException e) {
            LOGGER.error(e);
        }
    }
}
