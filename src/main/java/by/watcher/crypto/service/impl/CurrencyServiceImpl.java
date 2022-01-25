package by.watcher.crypto.service.impl;

import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final List<Currency> currencyRepository = new ArrayList<>();

    public void addCurrency(Currency currency) {
        currencyRepository.add(currency);
    }

    public List<Currency> getAll() {
        return currencyRepository;
    }

    @Override
    public Optional<Currency> getCurrencyById(long id) {
        return currencyRepository.stream().filter(currency -> currency.getId() == id).findFirst();
    }

}
