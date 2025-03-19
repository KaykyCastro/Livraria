package interfaces;

import exception.UserNotExistException;
import model.User;

import java.util.List;

public interface UserCollection {
    public void addUser(User user);
    public User getUser(String cpf)throws UserNotExistException;
    public void removeUser(String cpf)throws UserNotExistException;
    public List<User> getAllUser();
}
