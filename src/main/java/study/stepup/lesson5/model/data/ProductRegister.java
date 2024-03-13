package study.stepup.lesson5.model.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tpp_product_register")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne//(mappedBy = "productRegisterId")
    @JoinColumn (name="product_id")
    private Product productId;

    @ManyToOne
    @JoinColumn (name="type")
    private ProductRegisterType type;

    private int account;

    @Column(name = "currency_code")
    private String currencyCode;

    private String state;

    @Column(name = "account_number")
    private String accountNumber;
}
