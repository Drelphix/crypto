package by.watcher.crypto.service;

import by.watcher.crypto.model.entities.Price;

import java.util.List;


public interface PriceService{
    List<Price> saveAll(List<Price> prices);
    Price getActualPriceByIdCurrency(long id);
    Price savePrice(Price price);
}
