package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.Dish;
import gastro.com.restaurantadministration.dish.DishServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${api.v1}" + "/bill")
public class BillController {
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);
    private final DishServiceImpl dishService;
    private final BillServiceImpl billService;

    @Autowired
    public BillController(DishServiceImpl dishService, BillServiceImpl billService) {
        this.dishService = dishService;
        this.billService = billService;
    }

    @GetMapping("/initBill")
    public String newBill(Model model) {
        Bill bill = new Bill();
        model.addAttribute("allDishes", dishService.getListAllDishes());
        model.addAttribute("newBill", bill);
        return "init-bill";
    }

    @GetMapping("/addDish/{dishId}/toBill/{billId}")
    public String addDishToBill(@PathVariable Long dishId, @PathVariable Long billId, Model model) {
        Bill bill = new Bill();
        Dish dish = (Dish) model.getAttribute("addedDish");
        
        logger.info("new from model bill: " + bill);
        logger.info("Try add dish to bill.");
        if (bill != null && dish != null) {
            billService.addDishToBill(dish, bill);
            logger.info(dish.name + " added.");
        } else {
            logger.warn("Bill and/or dish not exist.");
            logger.info(bill.toString());
        }
        model.addAttribute("allDishes", dishService.getListAllDishes());
        model.addAttribute("newBill", bill);
        return "init-bill";
    }

    @GetMapping("/all")
    public String getAllBills(Model model) {
        model.addAttribute("allBills", billService.getAllBills());
        return "all-bills";
    }
}
