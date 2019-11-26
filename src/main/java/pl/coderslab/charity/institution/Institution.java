package pl.coderslab.charity.institution;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//TODO czy jest jakaś przyjęta kolejność wpisywania adnotacji np przy lomboku
//TODO czy lepiej dać lombok @Data czy tylko getery i setery
@Getter
@Setter
@Entity
@Table(name = "institutions")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToMany(mappedBy = "institution")
    Long id;

    @NotNull
    String name;

    String description;
}
