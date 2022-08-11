package gastro.com.restaurantadministration.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@RequestMapping("${api.v1}" + "/dish")
public class DishController implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(DishController.class);
    private final DishServiceImpl dishService;

    @Autowired
    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/allDishes")
    public String getListAllDishes(Model model) {
        model.addAttribute("allDishes", dishService.getListAllDishes());
        logger.info(dishService.getListAllDishes().toString());
        return "dish-list";
    }

    @GetMapping("/addDish")
    public String showForm(Model model, Dish dish) {
        model.addAttribute("dishForm", dish);
        logger.info("[get]get dish");
        return "forms/dish-form";
    }

    @PostMapping("/addDish")
    public String checkDish(@Valid Dish dish, BindingResult bindingResult, Model model) {
        logger.info("[post]get dish");
        if (bindingResult.hasErrors()) {
            model.addAttribute("dishForm", dish);
            return "forms/dish-form";
        }
        dishService.addDish(dish);
        return "redirect:/api/v1/dish/allDishes";
    }

    @GetMapping("removeDish/{id}")
    public String removeDish(@PathVariable("id")Long id) {
        dishService.removeDish(id);
        return "redirect:/api/v1/dish/allDishes";
    }
}
