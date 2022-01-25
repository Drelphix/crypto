package by.watcher.crypto.config;

import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ServerConfigOnStartUp {

    @Autowired
    private CurrencyService currencyService;
    
    @EventListener(ApplicationStartedEvent.class)
    public void runAfterStartup() {
        Currency btc = new Currency(90, "bitcoin", "BTC");
        Currency eth = new Currency(80, "etherium", "ETH");
        Currency sol = new Currency(48543, "solana", "SOL");
        currencyService.addCurrency(btc);
        currencyService.addCurrency(eth);
        currencyService.addCurrency(sol);
    }
}