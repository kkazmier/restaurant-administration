package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.Dish;

import java.util.List;

public interface BillService {
    Bill addBill(Bill bill);
    List<Bill> getAllBills();
    void addDish(Long dishId);
    void removeDish(Long dishId);
    List<Dish> getDishes();
    void confirmBill();
}
