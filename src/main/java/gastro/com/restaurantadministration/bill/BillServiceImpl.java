package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.Dish;
import gastro.com.restaurantadministration.dish.DishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    public static final Logger logger= LoggerFactory.getLogger(BillServiceImpl.class);
    private final DishRepository dishRepository;
    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(DishRepository dishRepository, BillRepository billRepository) {
        this.dishRepository = dishRepository;
        this.billRepository = billRepository;
    }

    @Override
    public Bill addBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Dish addDishToBill(Dish dish, Bill bill) {

        return dish;
    }

    @Override
    public Boolean removeDishFromBill(Dish dish, Bill bill) {
        if (bill.getDishes().contains(dish)) {
            bill.getDishes().remove(dish);
            logger.info(dish + " removed.");
            return true;
        } else {
            return false;
        }
    }
}
