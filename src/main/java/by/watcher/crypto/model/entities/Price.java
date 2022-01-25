package by.watcher.crypto.model.entities;

import javax.persistence.*;

@Entity
@Table
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long idCurrency;

    @Column(nullable = false)
    private double price;

    public Price() {
    }

    public Price(long idCurrency, double price) {
        this.idCurrency = idCurrency;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(long idCurrency) {
        this.idCurrency = idCurrency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
