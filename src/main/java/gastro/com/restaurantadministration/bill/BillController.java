package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.DishServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("${api.v1}" + "/bill")
@SessionAttributes("newBill")
public class BillController {
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);

    private final DishServiceImpl dishService;

    @Autowired
    public BillController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @ModelAttribute("newBill")
    public Bill newBill() {
        return new Bill();
    }

    @GetMapping("/bills")
    public String bills() {
        return "bills";
    }

    @GetMapping("/newBill")
    public String newBill(Model model, @ModelAttribute("newBill") Bill newBill) {
        if(newBill != null) {
            newBill = new Bill();
        }
        model.addAttribute("allDishes", dishService.getListAllDishes());
        return "new-bill";
    }

    @GetMapping("/addDish/{dishId}/toBill")
    public String addDishToBill(@ModelAttribute("newBill") Bill newBill,
                                @PathVariable("dishId") Long dishId, Model model) {
        if(newBill != null) {
            newBill = new Bill();
        }

        model.addAttribute("allDishes", dishService.getListAllDishes());
        logger.info("Add dish " + dishId + " to bill ");
        logger.info(String.valueOf(newBill.getDishes().size()));
        return "new-bill";
    }
}
