package gastro.com.restaurantadministration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@Getter
@Setter
public class RestaurantWorker extends Person {
    private String username;
    private String password;
    @Transient
    private String passwordConfirm;
}
