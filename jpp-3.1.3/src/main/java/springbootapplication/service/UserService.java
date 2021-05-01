package springbootapplication.service;

import springbootapplication.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    void delete(int id);

    User update(User user);

    void encodePassword(User user);

    List<User> getAllUsers();

    User findById(int id);

    User findByEmail(String email);
}
