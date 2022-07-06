package gastro.com.restaurantadministration.waiter;

import gastro.com.restaurantadministration.model.RestaurantWorker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "waiters", schema = "public")
public class Waiter extends RestaurantWorker {

}
