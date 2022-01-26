package by.watcher.crypto.config;

import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ServerConfig {

    @Autowired
    private CurrencyService currencyService;

    @PostConstruct
    public void ConfigCurrencyRepository() {
        Currency btc = new Currency(90, "bitcoin", "BTC");
        Currency eth = new Currency(80, "etherium", "ETH");
        Currency sol = new Currency(48543, "solana", "SOL");
        currencyService.addCurrency(btc);
        currencyService.addCurrency(eth);
        currencyService.addCurrency(sol);
    }
}