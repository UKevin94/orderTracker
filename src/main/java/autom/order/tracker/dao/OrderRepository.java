package autom.order.tracker.dao;

import autom.order.tracker.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
