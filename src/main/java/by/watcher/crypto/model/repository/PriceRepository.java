package by.watcher.crypto.model.repository;

import by.watcher.crypto.model.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT * FROM currency.price where id_currency=?1 ORDER BY id DESC limit 1")
    Price getActualPriceByIdCurrency(long id);
}
