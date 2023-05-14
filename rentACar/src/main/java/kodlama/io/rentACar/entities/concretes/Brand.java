package kodlama.io.rentACar.entities.concretes;



import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;


//@Data//parametsiz constructır hariç herşeyi getirir
@Table(name="brands")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Brand {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

}

