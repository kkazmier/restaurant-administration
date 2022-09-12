package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.DishServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
@RequestMapping("${api.v1}" + "/bill")
public class BillController {
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);

    private final BillServiceImpl billService;
    private final DishServiceImpl dishService;

    @Autowired
    public BillController(BillServiceImpl billService, DishServiceImpl dishService) {
        this.billService = billService;
        this.dishService = dishService;
    }

    @GetMapping("/bills")
    public String bills(Model model) {
        model.addAttribute("bills", billService.getAllBills());
        return "bills";
    }

    @GetMapping("/newBill")
    public String newBill(Model model) {
        model.addAttribute("allDishes", dishService.getListAllDishes());
        return "new-bill";
    }

    @GetMapping("/addDish/{dishId}/toBill")
    public String addDishToBill(@PathVariable("dishId") Long dishId, Model model) {
        billService.addDish(dishId);
        model.addAttribute("allDishes", dishService.getListAllDishes());
        model.addAttribute("selectedDishes", billService.getDishes());
        logger.info("Add dish " + dishId + " to bill ");
        return "new-bill";
    }

    @GetMapping("/confirmBill")
    public String confirmBill() {

        return "bills";
    }
}
