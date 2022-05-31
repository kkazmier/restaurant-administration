package gastro.com.restaurantadministration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

