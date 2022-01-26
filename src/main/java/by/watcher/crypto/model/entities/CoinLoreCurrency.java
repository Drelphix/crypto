package by.watcher.crypto.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinLoreCurrency {
    @JsonProperty("id")
    private long id;
    @JsonProperty("price_usd")
    private double priceUsd;

    public CoinLoreCurrency() {
    }

    public CoinLoreCurrency(long id, double priceUsd) {
        this.id = id;
        this.priceUsd = priceUsd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoinLoreCurrency that = (CoinLoreCurrency) o;

        if (id != that.id) return false;
        return Double.compare(that.priceUsd, priceUsd) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(priceUsd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "CoinLoreCurrency{" +
                "id=" + id +
                ", priceUsd=" + priceUsd +
                '}';
    }
}
