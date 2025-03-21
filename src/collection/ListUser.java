package collection;

import exception.UserNotExistException;
import interfaces.UserCollection;
import model.User;

import java.util.List;

public class ListUser implements UserCollection {

    private List<User> users;

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public User getUser(String cpf) throws UserNotExistException {
        for(User user : this.users){
            if(user.getCpf().equals(cpf)){
                return user;
            }
        }throw new UserNotExistException();
    }

    @Override
    public void removeUser(String cpf) throws UserNotExistException {
        User userToRemove = getUser(cpf);
        this.users.remove(userToRemove);
    }

    @Override
    public List<User> getAllUser() {
        return users;
    }
}
