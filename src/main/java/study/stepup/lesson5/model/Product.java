package study.stepup.lesson5.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tpp_product")
//@Setter
//@Getter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_code_id")
    private int productCodeId;

    @Column(name = "client_id")
    private int clientId;
    private String type;
    private String number;
    private int priority;

    @Column(name = "date_of_conclusion")
    private Timestamp dateOfConclusion;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;
    private int days;
    private float penalty_rate;
    private float nso;

    @Column(name = "threshold_amount")
    private float thresholdAmount;

    @Column(name = "requisite_type")
    private String requisiteType;

    @Column(name = "interest_rate_type")
    private String interestRateType;

    @Column(name = "tax_rate")
    private float taxRate;

    @Column(name = "reason_close")
    private String reasonClose;
    private String state;
//    @Transient
//    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ProductRegister> registers = new ArrayList<>();
//    @Transient
//    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Agreements> agreements = new ArrayList<>();
//
//    public void addAgreement(Agreements agreement){
//        this.agreements.add(agreement);
//        agreement.setProduct(this);
//    }
//    public void addRegistr(ProductRegister register){
//        this.registers.add(register);
//        register.setProduct(this);
//    }

}
