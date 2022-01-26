package by.watcher.crypto.model.entities;

import by.watcher.crypto.model.entities.Currency;
import by.watcher.crypto.model.entities.Price;

public class User {

    private String name;

    private Currency currency;

    private Price price;

    public User(String name, Currency currency, Price price) {
        this.name = name;
        this.currency = currency;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!currency.equals(user.currency)) return false;
        return price.equals(user.price);
    }

    @Override
    public int hashCode() {
        int result = 31 * name.hashCode();
        result = 31 * result + currency.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", currency=" + currency +
                ", price=" + price +
                '}';
    }
}
