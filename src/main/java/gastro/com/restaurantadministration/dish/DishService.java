package gastro.com.restaurantadministration.dish;

import java.util.List;

public interface DishService {
    List<Dish> getListAllDishes();
    Dish addDish(Dish dish);
}
