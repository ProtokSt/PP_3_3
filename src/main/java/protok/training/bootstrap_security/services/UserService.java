package protok.training.bootstrap_security.services;


import protok.training.bootstrap_security.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User findByUsername(String username);

    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);
}
