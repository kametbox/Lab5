package study.stepup.lesson5.model.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tpp_ref_product_register_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRegisterType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internal_id")
    private int internalId;

    private String value;

    @Column(name = "register_type_name")
    private String registerTypeName;

    //@Column (name="product_class_code")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_class_code")
    private ProductClass productClassCode;

    //@Column (name="account_type")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_type")
    private AccountType accountType;
}
