package pl.coderslab.charity.donation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //TODO quantity żle zczytuje liczbę. podaje 3 zamiast 1.
    @NotNull(message = "{quantity.notNull}")
    @Min(value = 1, message = "{quantity.min}")
    @Max(value=10, message="{quantity.max}")
    int quantity;

    @NotEmpty(message = "{categories.notEmpty}")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "donation_category",
            joinColumns = @JoinColumn(name = "donation_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categories;

    @NotNull(message = "{institution.notNull}")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "institution_id")
    Institution institution;

    @Size(min=3, max=20, message = "{size}")
    String street;

    @Size(min=3, max=20, message = "{size}")
    String city;

    @Pattern(regexp = "\\d{2}-\\d{3}", message = "{zipCode.pattern}")
    String zipCode;
    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message="{phone.pattern")
    String phone;

    @NotNull(message = "{pickUpDate.notNull}")
    @Future(message = "{pickUpDate.future}")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    LocalDate pickUpDate;

    @NotNull(message = "{pickUpTime.notNull}")
    LocalTime pickUpTime;

    @Range(min=5, max=255, message = "{size}")
    String pickUpComment;

//    public LocalDate getPickUpDate() {
//        return pickUpDate;
//    }
//
//    public void setPicUpDate(LocalDate pickUpDate) {
//        this.pickUpDate = pickUpDate;
//    }

}
