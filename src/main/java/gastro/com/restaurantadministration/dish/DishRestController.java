package gastro.com.restaurantadministration.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.v1.rest}" + "/dish")
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
