package gastro.com.restaurantadministration.dish;

import gastro.com.restaurantadministration.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dishes", schema = "public")
public class Dish extends BaseEntity {
    @NotEmpty(message = "{dish.name.notempty}")
    public String name;

    @NotNull(message = "{dish.name.notempty}")
    @DecimalMin(value = "0.01", message = "{dish.price.value}")
    private BigDecimal price;

    private String description;
}
