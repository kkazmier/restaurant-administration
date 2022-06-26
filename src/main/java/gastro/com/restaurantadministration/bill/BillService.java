package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.Dish;

import java.util.List;
import java.util.Optional;

public interface BillService {
    Bill addBill(Bill bill);
    Optional<Bill> findById(Long id);
    Dish addDishToBill(Dish dish, Bill bill);
    Boolean removeDishFromBill(Dish dish, Bill bill);
    List<Bill> getAllBills();
}
