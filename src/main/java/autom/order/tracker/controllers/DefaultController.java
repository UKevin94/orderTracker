package autom.order.tracker.controllers;

import autom.order.tracker.dao.OrderRepository;
import autom.order.tracker.dao.UserRepository;
import autom.order.tracker.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class DefaultController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/error")
    public String error(){
        return "error";
    }

/*    @GetMapping("/login")
    public String login() {
        return "login";
    }*/

    /*@PostMapping("/perform-login")
    public String perform_login(){

    }*/

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

    @GetMapping("/add-order")
    public String addOrderForm(Model model){
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("order", new Order());
        return "add-order";
    }

    @PostMapping("/add-order")
    public String addOrderSubmit(@ModelAttribute Order order){
        orderRepository.save(order);
        return "redirect:/list-orders";
    }
}
