package autom.order.tracker.controllers;

import autom.order.tracker.dao.OrderRepository;
import autom.order.tracker.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class DefaultController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/list-users")
    public String listUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "list-users";
    }

    @GetMapping("/list-orders")
    public String listOrders(Model model){
        model.addAttribute("orders", orderRepository.findAll());
        return "list-orders";
    }
}
