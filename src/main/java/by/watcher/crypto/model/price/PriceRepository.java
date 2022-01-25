package by.watcher.crypto.model.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("Select TOP 1 from price")
    Price getActualPriceByIdCurrency(long id);
}
