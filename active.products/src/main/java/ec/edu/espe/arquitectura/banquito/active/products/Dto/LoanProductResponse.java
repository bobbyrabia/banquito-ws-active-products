package ec.edu.espe.arquitectura.banquito.active.products.Dto;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.espe.arquitectura.banquito.active.products.model.LoanRequirement;
import ec.edu.espe.arquitectura.banquito.active.products.model.ProductArrearsSetting;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
public class LoanProductResponse {
    private String uniqueId;
    private List<ProductArrearsSetting> productArrearsSettings;
    private LoanRequirement loanRequirement;
    private BigDecimal cappingPercentage;
    private String cappingMethod;
    private String interestType;
    private String name;
    private String description;
    private BigDecimal defaultLoanAmount;
    private BigDecimal minLoanAmount;
    private BigDecimal maxLoanAmount;
    private Integer defaultNumInstallments;
    private Integer minNumInstallments;
    private Integer maxNumInstallments;
    private Integer defaultGracePeriod;
    private Integer minGracePeriod;
    private Integer maxGracePeriod;
    private String gracePeriodType;
    private Integer defaultRepaymentPeriodCount;
    private String repaymentPeriodUnit;
    private BigDecimal defaultPenaltyRate;
    private BigDecimal minPenaltyRate;
    private BigDecimal maxPenaltyRate;
    private String interestCalculationMethod;
    private String loanPenaltyCalculationMethod; 
    private Boolean valid;

}
