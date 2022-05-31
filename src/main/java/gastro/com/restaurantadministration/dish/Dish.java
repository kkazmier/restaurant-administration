package gastro.com.restaurantadministration.dish;

import gastro.com.restaurantadministration.model.BaseEntity;
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
@Table(name = "dishes", schema = "public")
public class Dish extends BaseEntity {
    public String name;
}
