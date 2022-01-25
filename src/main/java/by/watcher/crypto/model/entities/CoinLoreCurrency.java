package by.watcher.crypto.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinLoreCurrency {
    @JsonProperty("id")
    private long id;
    @JsonProperty("price_usd")
    private double priceUsd;

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

    public CoinLoreCurrency() {
    }

    public CoinLoreCurrency(long id, double priceUsd) {
        this.id = id;
        this.priceUsd = priceUsd;
    }
}
