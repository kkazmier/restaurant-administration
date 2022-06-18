package gastro.com.restaurantadministration.bill;

import gastro.com.restaurantadministration.dish.Dish;

public interface BillService {
    Bill addBill(Bill bill);
    Dish addDishToBill(Dish dish, Bill bill);
    Boolean removeDishFromBill(Dish dish, Bill bill);
}
