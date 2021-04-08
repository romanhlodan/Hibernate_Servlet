package entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "person")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int graduation_year;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Person person;
}
