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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price1 = (Price) o;

        if (id != price1.id) return false;
        if (idCurrency != price1.idCurrency) return false;
        return Double.compare(price1.price, price) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idCurrency ^ (idCurrency >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", idCurrency=" + idCurrency +
                ", price=" + price +
                '}';
    }
}
