package study.stepup.lesson5.model.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name = "account_pool_id")
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id")
    @JoinColumn(name = "account_pool_id")
    private AccountPool accountPoolId;

    @Column(name = "account_number")
    private String accountNumber;
}
