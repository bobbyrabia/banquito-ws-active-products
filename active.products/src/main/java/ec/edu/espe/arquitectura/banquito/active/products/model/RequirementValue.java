package ec.edu.espe.arquitectura.banquito.active.products.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Requirement_Value")
public class RequirementValue {
    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueId;
    private Integer loanProductId;
    private Integer loanRequirementId;
    private BigDecimal numberField;
    private String freeTextField;
    private Date dateField;
    @Version
    private Long version;

    private List<LoanProduct> nameProduct;
    private List<LoanRequirement> nameRequirement;
}