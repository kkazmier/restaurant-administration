package gastro.com.restaurantadministration.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private static final Logger logger = LoggerFactory.getLogger(DishServiceImpl.class);
    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getListAllDishes() {
        return (List<Dish>) dishRepository.findAll();
    }

    @Override
    public Dish getDish(Long dishId) {
        logger.info("Get dish by id: " + dishId);
        return dishRepository.findById(dishId).get();
    }

    @Override
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Boolean removeDish(Long id) {
        if(dishRepository.existsById(id)) {
            Dish dish = dishRepository.findById(id).get();
            dishRepository.delete(dish);
            logger.info("Delete " + dish);
            return  true;
        } else {
            logger.info("Dish not found.");
            return false;
        }
    }
}
