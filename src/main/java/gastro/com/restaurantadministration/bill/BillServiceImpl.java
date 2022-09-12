package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.Dish;
import gastro.com.restaurantadministration.dish.DishRepository;
import gastro.com.restaurantadministration.dish.DishServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BillServiceImpl implements BillService {
    private static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);
    private final BillRepository billRepository;
    private final DishRepository dishRepository;
    private final DishServiceImpl dishService;
    private List<Dish> dishes = new ArrayList<>();

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
        if(dish.isPresent()) {
            dishes.add(dish.get());
        }
    }

    @Override
    public List<Dish> getDishes() {
        return dishes;
    }
}
