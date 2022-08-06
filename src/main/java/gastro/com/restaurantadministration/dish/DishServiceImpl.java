package gastro.com.restaurantadministration.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
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
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }
}
