package study.stepup.lesson5.model.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tpp_ref_product_class")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internal_id")
    private int internalId;

    private String value;

    @Column(name = "gbi_code")
    private String gbiCode;

    @Column(name = "gbi_name")
    private String gbiName;

    @Column(name = "product_row_code")
    private String productRowCode;

    @Column(name = "product_row_name")
    private String productRowName;

    @Column(name = "subclass_code")
    private String subclassCode;

    @Column(name = "subclass_name")
    private String subclassName;
}
