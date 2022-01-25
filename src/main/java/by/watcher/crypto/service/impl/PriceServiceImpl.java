package by.watcher.crypto.service.impl;

import by.watcher.crypto.model.price.Price;
import by.watcher.crypto.model.price.PriceRepository;
import by.watcher.crypto.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> saveAll(List<Price> prices) {
        return priceRepository.saveAll(prices);
    }

    @Override
    public Price getActualPriceByIdCurrency(long id) {
        return priceRepository.getActualPriceByIdCurrency(id);
    }
}
