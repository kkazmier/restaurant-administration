package gastro.com.restaurantadministration.dish;

import java.util.List;

public interface DishService {
    List<Dish> getListAllDishes();
    Dish getDish(Long dishId);
    Dish addDish(Dish dish);
    Boolean removeDish(Long id);
}
