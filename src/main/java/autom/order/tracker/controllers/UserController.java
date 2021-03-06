package autom.order.tracker.controllers;

import autom.order.tracker.dao.UserRepository;
import autom.order.tracker.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam(value="login") String login, @RequestParam(value="password") String password, @RequestParam(value="mail") String mail){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setMail(mail);
        user.setAdmin(false);
        userRepository.save(user);
        return "Done";
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/view")
    public @ResponseBody Optional<User> getUser(@RequestParam Integer id){
        return userRepository.findById(id);
    }
}
