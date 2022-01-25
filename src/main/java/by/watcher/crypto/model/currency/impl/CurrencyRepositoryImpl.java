package by.watcher.crypto.model.currency.impl;

import by.watcher.crypto.model.currency.Currency;
import by.watcher.crypto.model.currency.CurrencyRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class CurrencyRepositoryImpl implements CurrencyRepository {
    private List<Currency> currencyList = new ArrayList<>();

    private static final CurrencyRepository CURRENCY_REPOSITORY = new CurrencyRepositoryImpl();


    public static CurrencyRepository getInstance() {
        return CURRENCY_REPOSITORY;
    }

    public boolean addCurrency(Currency currency){
        return false;
    }

    public List<Currency> getAll() {
        return null;
    }

    @Override
    public Optional<Currency> getCurrencyById(long id) {
        return currencyList.stream().filter(currency -> currency.getId()==id).findFirst();
    }


}
