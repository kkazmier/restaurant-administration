package gastro.com.restaurantadministration.dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    List<Dish> getListAllDishes();
    Dish addDish(Dish dish);
    Optional<Dish> findById(Long id);
}
