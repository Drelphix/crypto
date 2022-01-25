package by.watcher.crypto.model.currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository {
    boolean addCurrency(Currency currency);
    List<Currency> getAll();
    Optional<Currency> getCurrencyById(long id);
}
