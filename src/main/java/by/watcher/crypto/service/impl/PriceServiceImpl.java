package by.watcher.crypto.service.impl;

import by.watcher.crypto.model.entities.Price;
import by.watcher.crypto.model.repository.PriceRepository;
import by.watcher.crypto.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public Price savePrice(Price price) {
        return priceRepository.save(price);
    }
}
