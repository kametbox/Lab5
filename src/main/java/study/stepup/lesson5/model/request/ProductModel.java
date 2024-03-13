package study.stepup.lesson5.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    Integer instanceId;
    @RequiredField String productType;
    @RequiredField String productCode;
    @RequiredField String registerType;
    @RequiredField String mdmCode;
    @RequiredField String contractNumber;
    @RequiredField Date contractDate;
    @RequiredField Integer priority;
    Float interestRatePenalty;
    Float minimalBalance;
    Float thresholdAmount;
    String accountingDetails;
    String rateType;
    Float taxPercentageRate;
    Float technicalOverdraftLimitAmount;
    @RequiredField Integer contractId;
    @RequiredField String branchCode;
    @RequiredField String isoCurrencyCode;
    @RequiredField String urgencyCode;
    Integer referenceCode;

    AdditionalPropertiesModel additionalPropertiesVip;
    ArrayList<AgreementModel> instanceArrangement;
}
