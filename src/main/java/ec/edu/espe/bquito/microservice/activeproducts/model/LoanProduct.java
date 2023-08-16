package ec.edu.espe.arquitectura.banquito.active.products.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import java.util.List;

@Setter 
@Getter 
@NoArgsConstructor
@Document(collection = "loan_product")
public class LoanProduct {
    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueId;
    private List<ProductArrearsSetting> productArrearsSettings;
    private LoanRequirement loanRequirement;
    private Long creationDate;
    private Long lastModifiedDate;
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
    @Version
    private Long version;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uniqueId == null) ? 0 : uniqueId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LoanProduct other = (LoanProduct) obj;
        if (uniqueId == null) {
            if (other.uniqueId != null)
                return false;
        } else if (!uniqueId.equals(other.uniqueId))
            return false;
        return true;
    }



    
}
