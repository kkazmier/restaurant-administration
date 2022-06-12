package gastro.com.restaurantadministration.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("${api.v1.rest}" + "/dish")
public class DishController {
    private final DishServiceImpl dishService;

    @Autowired
    public DishController(DishServiceImpl dishService) {
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
