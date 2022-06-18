package gastro.com.restaurantadministration.bill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${api.v1}" + "/bill")
public class BillController {
    private static final Logger logger = LoggerFactory.getLogger(BillController.class);
    private final BillServiceImpl billService;

    @Autowired
    public BillController(BillServiceImpl billService) {
        this.billService = billService;
    }

    @GetMapping("/newBill")
    public String newBill() {
        return "dish-list";
    }
}
