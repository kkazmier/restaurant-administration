package gastro.com.restaurantadministration.bill;

import java.util.List;

public interface BillService {
    Bill addBill(Bill bill);
    List<Bill> getAllBills();
}
