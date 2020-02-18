package autom.order.tracker.dao;

import autom.order.tracker.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
