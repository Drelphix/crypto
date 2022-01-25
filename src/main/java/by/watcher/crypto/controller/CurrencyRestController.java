package by.watcher.crypto.controller;

import by.watcher.crypto.message.ErrorMessage;
import by.watcher.crypto.model.entities.CoinLoreCurrency;
import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.model.repository.PriceRepository;
import by.watcher.crypto.service.CoinLoreService;
import by.watcher.crypto.service.CurrencyService;
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

    @RequestMapping(value = "/getAll")
    public ResponseEntity<Iterable<Currency>> getCryptoCurrencyList() {

        try{
            return new ResponseEntity<Iterable<Currency>>(currencyService.getAll(), HttpStatus.OK);
        }
        catch (Exception e){
            LOGGER.error(ErrorMessage.GET_CRYPTO_CURRENCY_LIST_ERROR, e);
            return new ResponseEntity<Iterable<Currency>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ResponseEntity<Currency> getCryptoCurrencyById(@RequestParam(value="id", required=true) long id) {
        Optional<Currency> currency = currencyService.getCurrencyById(id);
        try {
            if (currency.isPresent()) {
                return new ResponseEntity<Currency>(currency.get(), HttpStatus.OK);
            }
        } catch (Exception e) {
            LOGGER.error(ErrorMessage.GET_CRYPTO_CURRENCY_BY_ID_ERROR, e);
        }
        return new ResponseEntity<Currency>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<CoinLoreCurrency> test(){
        try {
            return new ResponseEntity<CoinLoreCurrency>(coinLoreService.getCurrencyById(90), HttpStatus.OK);
        } catch (Exception e){
            LOGGER.error(ErrorMessage.GET_CRYPTO_CURRENCY_BY_ID_ERROR, e);
        }
        return new ResponseEntity<CoinLoreCurrency>(HttpStatus.OK);
    }
}
