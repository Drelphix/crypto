package by.watcher.crypto.service;

import by.watcher.crypto.model.price.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceService{
    List<Price> saveAll(List<Price> prices);
    Price getActualPriceByIdCurrency(long id);
}
