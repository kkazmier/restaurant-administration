package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.Dish;
import gastro.com.restaurantadministration.dish.DishRepository;
import gastro.com.restaurantadministration.dish.DishServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {
    private static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);
    private final BillRepository billRepository;
    private final DishRepository dishRepository;
    private final DishServiceImpl dishService;

    private Map<Dish, Integer> dishes = new HashMap<>();

    @Autowired
    public BillServiceImpl(BillRepository billRepository, DishRepository dishRepository, DishServiceImpl dishService) {
        this.billRepository = billRepository;
        this.dishRepository = dishRepository;
        this.dishService = dishService;
    }

    @Override
    public Bill addBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return (List<Bill>) billRepository.findAll();
    }

    @Override
    public void addDish(Long dishId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        if(dishes.containsKey(dish)) {
            dishes.replace(dish.get(), dishes.get(dish) + 1);
        } else {
            dishes.put(dish.get(), 1);
        }
    }

    @Override
    public Map<Dish, Integer> getDishes() {
        return dishes;
    }
}
