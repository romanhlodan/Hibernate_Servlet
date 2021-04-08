package entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"passport","cars"})
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private Passport passport;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Car> cars;
}
