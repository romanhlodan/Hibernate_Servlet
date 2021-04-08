package entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "person")
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String serialNumber;
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Person person;
}
