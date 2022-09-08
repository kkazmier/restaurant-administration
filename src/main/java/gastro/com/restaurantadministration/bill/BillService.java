package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.Dish;

import java.util.List;
import java.util.Map;

public interface BillService {
    Bill addBill(Bill bill);
    List<Bill> getAllBills();
    void addDish(Long dishId);
    Map<Dish, Integer> getDishes();
}
