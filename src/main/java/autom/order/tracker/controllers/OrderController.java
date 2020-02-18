package autom.order.tracker.controllers;

import autom.order.tracker.dao.OrderRepository;
import autom.order.tracker.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewOrder(@RequestParam String customer, @RequestParam String products, @RequestParam Date orderDate, @RequestParam int price){
        Order order = new Order();
        order.setCustomer(customer);
        order.setProducts(products);
        order.setPrice(price);
        order.setOrderDate(orderDate);
        orderRepository.save(order);
        return "Order saved";
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/view")
    public @ResponseBody Optional<Order> getOrder(@RequestParam Integer id){
        return orderRepository.findById(id);
    }
}
