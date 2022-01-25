package by.watcher.crypto.model.repository;

import by.watcher.crypto.model.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Price getActualPriceByIdCurrency(long id);
}
