package study.stepup.lesson5.model.data;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "agreement")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name="product_id")
    private Product product;

    @Column(name = "currency_code")
    private String generalAgreementId;

    @Column(name = "supplementary_agreement_id")
    private String supplementaryAgreementId;

    @Column(name = "arrangement_type")
    private String arrangementType;

    @Column(name = "sheduler_job_id")
    private Integer shedulerJobId;

    private String number;

    @Column(name = "opening_date")
    private Timestamp openingDate;

    @Column(name = "closing_date")
    private Timestamp closingDate;

    @Column(name = "cancel_date")
    private Timestamp cancelDate;

    @Column(name = "validity_duration")
    private Integer validityDuration;

    @Column(name = "cancellation_reason")
    private String cancellationReason;

    private String status;

    @Column(name = "interest_calculation_date")
    private Timestamp interestCalculationDate;

    @Column(name = "interest_rate")
    private Float interestRate;

    private Float coefficient;

    @Column(name = "coefficient_action")
    private String coefficientAction;

    @Column(name = "minimum_interest_rate")
    private Float minimumInterestRate;

    @Column(name = "minimum_interest_rate_coefficient")
    private Float minimumInterestRateCoefficient;

    @Column(name = "minimum_interest_rate_coefficient_action")
    private String minimumInterestRateCoefficientAction;

    @Column(name = "maximal_interest_rate")
    private Float maximalInterestRate;

    @Column(name = "maximal_interest_rate_coefficient")
    private Float maximalInterestRateCoefficient;

    @Column(name = "maximal_interest_rate_coefficient_action")
    private String maximalInterestRateCoefficientAction;

}
