package study.stepup.lesson5.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgreementModel {
    String generalAgreementId;
    String supplementaryAgreementId;
    String arrangementType;
    Integer shedulerJobId;
    @RequiredField String number;
    @RequiredField String openingDate;
    String closingDate;
    String cancelDate;
    int validityDuration;
    String cancellationReason;
    String status;
    String interestCalculationDate;
    float interestRate;
    float coefficient;
    String coefficientAction;
    float minimumInterestRate;
    float minimumInterestRateCoefficient;
    String minimumInterestRateCoefficientAction;
    float maximalInterestRate;
    float maximalInterestRateCoefficient;
    String maximalInterestRateCoefficientAction;
}
