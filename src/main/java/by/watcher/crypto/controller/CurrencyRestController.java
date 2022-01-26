package by.watcher.crypto.controller;

import by.watcher.crypto.exception.UserServiceException;
import by.watcher.crypto.message.Message;
import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.model.entities.User;
import by.watcher.crypto.model.repository.PriceRepository;
import by.watcher.crypto.service.CoinLoreService;
import by.watcher.crypto.service.CurrencyService;
import by.watcher.crypto.service.UserService;
import by.watcher.crypto.validator.CurrencyValidator;
import by.watcher.crypto.view.PriceView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CurrencyRestController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CoinLoreService coinLoreService;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CurrencyValidator currencyValidator;

    @RequestMapping(value = "/getAll")
    public ResponseEntity<Iterable<Currency>> getCryptoCurrencyList() {

        try {
            return new ResponseEntity<>(currencyService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(Message.GET_CRYPTO_CURRENCY_LIST_ERROR, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ResponseEntity<PriceView> getCryptoCurrencyById(@RequestParam(value = "id") long id) {
        Optional<Currency> currency = currencyService.getCurrencyById(id);
        try {
            if (currency.isPresent()) {
                Currency currencyHolder = currency.get();
                long currencyId = currencyHolder.getId();
                String symbol = currencyHolder.getSymbol();
                double price = priceRepository.getActualPriceByIdCurrency(currencyId).getPrice();
                PriceView priceView = new PriceView(currencyHolder.getId(), currencyHolder.getSymbol(), price);
                return new ResponseEntity<>(priceView, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOGGER.error(Message.GET_CRYPTO_CURRENCY_BY_ID_ERROR, e);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/notify", method = RequestMethod.POST)
    public ResponseEntity<String> notify(@RequestParam(value = "username") String username, @RequestParam(value = "symbol") String symbol) {
        if (!currencyValidator.validateSymbol(symbol)) {
            LOGGER.error(Message.VALIDATING_SYMBOL_ERROR + symbol);
            return new ResponseEntity<>(Message.VALIDATING_SYMBOL_ERROR + symbol, HttpStatus.BAD_REQUEST);
        }
        try {
            User user = userService.registerUser(username, symbol);
            userService.addCurrentPriceToUser(user);
            return new ResponseEntity<>(Message.SUCCESS, HttpStatus.OK);
        } catch (UserServiceException e) {
            LOGGER.error(Message.GET_CRYPTO_CURRENCY_BY_SYMBOL_ERROR);
            return new ResponseEntity<>(Message.GET_CRYPTO_CURRENCY_BY_SYMBOL_ERROR, HttpStatus.BAD_REQUEST);
        }
    }
}
