package gastro.com.restaurantadministration.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishRestController {
    private final DishServiceImpl dishService;

    @Autowired
    public DishRestController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/allDishes")
    List<Dish> getListAllDishes() {
        return dishService.getListAllDishes();
    }

    @PostMapping("/addDish")
    Dish addDish(@RequestBody Dish dish){
        return dishService.addDish(dish);
    }
}
