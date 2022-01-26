package by.watcher.crypto.model.repository;

import by.watcher.crypto.model.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM currency.price where id_currency=:id ORDER BY id DESC LIMIT 1")
    Price getActualPriceByIdCurrency(@Param("id") long id);
}
