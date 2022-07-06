package gastro.com.restaurantadministration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;

}
