package study.stepup.lesson5.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tpp_ref_account_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internal_id")
    private int internalId;

    private String value;
}
