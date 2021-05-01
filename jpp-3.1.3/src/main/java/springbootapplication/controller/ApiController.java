package springbootapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootapplication.model.User;
import springbootapplication.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final UserService userService;

    @Autowired
    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        userService.encodePassword(user);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}
