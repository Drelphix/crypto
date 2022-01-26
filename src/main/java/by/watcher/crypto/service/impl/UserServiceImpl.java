package by.watcher.crypto.service.impl;

import by.watcher.crypto.exception.UserServiceException;
import by.watcher.crypto.message.Message;
import by.watcher.crypto.model.entities.CoinLoreCurrency;
import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.model.entities.Price;
import by.watcher.crypto.model.entities.User;
import by.watcher.crypto.service.CoinLoreService;
import by.watcher.crypto.service.CurrencyService;
import by.watcher.crypto.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger();
    private final List<User> userRepository = new ArrayList<>();

    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CoinLoreService coinLoreService;

    @Override
    public User registerUser(String username, String symbol) throws UserServiceException {
        Optional<Currency> currency = currencyService.findCurrencyBySymbol(symbol);
        Currency currencyHolder;
        if (currency.isPresent()) {
            currencyHolder = currency.get();
        } else throw new UserServiceException(Message.GET_CRYPTO_CURRENCY_BY_SYMBOL_ERROR);
        User user = new User(username, currencyHolder, new Price());
        userRepository.add(user);
        return user;
    }

    @Override
    public void addCurrentPriceToUser(User user) {
        long currencyId = user.getCurrency().getId();
        CoinLoreCurrency currency = coinLoreService.getCurrencyById(currencyId);
        Price price = user.getPrice();
        price.setPrice(currency.getPriceUsd());
        price.setIdCurrency(currency.getId());
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>(userRepository);
        return userList;
    }

    @Override
    public boolean checkUserPrice(List<Price> prices) {
        for (User user : userRepository) {
            long currencyId = user.getCurrency().getId();
            double userPrice = user.getPrice().getPrice();
            for (Price price : prices) {
                if (currencyId == price.getIdCurrency()) {
                    double currentPrice = price.getPrice();
                    if (Math.abs(userPrice / currentPrice) * 100 >= 1) {
                        LOGGER.warn("Price change more than 1% for user: " + user.getName() + ", From: " + userPrice + " to " + currentPrice);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
