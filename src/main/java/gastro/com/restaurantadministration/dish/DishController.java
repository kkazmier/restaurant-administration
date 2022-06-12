package gastro.com.restaurantadministration.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("${api.v1}" + "/dish")
public class DishController {
    private static final Logger logger = LoggerFactory.getLogger(DishController.class);
    private final DishServiceImpl dishService;

    @Autowired
    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/allDishes")
    List<Dish> getListAllDishes() {
        return dishService.getListAllDishes();
    }

    @GetMapping("/addDish")
    public String showForm(Model model, Dish dish) {
        model.addAttribute("dishForm", dish);
        logger.info("[get]get dish");
        return "forms/dish-form";
    }

    @PostMapping("/addDish")
    public String checkDish(@Valid Dish dish, BindingResult bindingResult) {
        logger.info("[post]get dish");
        if (bindingResult.hasErrors()) {
            return "dish-form";
        }
        return "redirect:/results";
    }
}
