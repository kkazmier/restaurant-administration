package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.DishServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${api.v1}" + "/bill")
public class BillController {
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);

    private final DishServiceImpl dishService;

    @Autowired
    public BillController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/bills")
    public String bills() {
        return "bills";
    }

    @GetMapping("/newBill")
    public String newBill(Model model) {
        model.addAttribute("allDishes", dishService.getListAllDishes());
        return "new-bill";
    }
}
