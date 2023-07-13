package ec.edu.espe.arquitectura.banquito.active.products.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Document(collection = "loan_product")

public class LoanProduct {
    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueId;
    private String interestType;
    private String name;
    private String description;
    private BigDecimal defaulLoanAmount;
    private BigDecimal minLoanAmount;
    private BigDecimal maxLoanAmount;
    private Integer defaultNumInstallments;
    private Integer minNumInstallments;
    private Integer maxNumInstallments;
    private Integer defaultGracePeriod;
    private Integer minGracePeriod;
    private Integer maxGracePeriod;
    private String gracePeriodType;
    private BigDecimal defaultPenaltyRate;
    private BigDecimal minPenaltyRate;
    private BigDecimal maxPenaltyRate;

    private Date created_at;
    private String created_by;
    private Date modified_at;
    private String modified_by;
    private Date valid_to;








}
