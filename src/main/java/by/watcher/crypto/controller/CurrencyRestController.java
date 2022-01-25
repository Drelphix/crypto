package by.watcher.crypto.controller;

import by.watcher.crypto.model.currency.Currency;
import by.watcher.crypto.model.currency.CurrencyRepository;
import by.watcher.crypto.model.currency.impl.CurrencyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CurrencyRestController {

    @RequestMapping("/getAll")
    public List<Currency> getCryptoCurrencyList() {
    return null;
    }

    @RequestMapping("/getById")
    public String getCryptoCurrencyById(@RequestParam(value="id", required=true) long id){
    CurrencyRepository currencyRepository = CurrencyRepositoryImpl.getInstance();
    Optional<Currency> currency = currencyRepository.getCurrencyById(id);
        if(currency.isPresent()){
           return currency.get().toString();
        }
        return "Can't find currency by id"; //fixme
    }
}
