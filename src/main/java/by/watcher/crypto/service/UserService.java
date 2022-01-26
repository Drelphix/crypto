package by.watcher.crypto.service;

import by.watcher.crypto.exception.UserServiceException;
import by.watcher.crypto.model.entities.Price;
import by.watcher.crypto.model.entities.User;

import java.util.List;

public interface UserService {


    User registerUser(String username, String symbol) throws UserServiceException;

    void addCurrentPriceToUser(User user);

    List<User> getAll();

    boolean checkUserPrice(List<Price> prices);
}
