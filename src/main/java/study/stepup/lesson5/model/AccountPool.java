package study.stepup.lesson5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_pool")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountPool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "mdm_code")
    private String mdmCode;

    @Column(name = "priority_code")
    private String priorityCode;

    @Column(name = "registry_type_code")
    private String registryTypeCode;


}
