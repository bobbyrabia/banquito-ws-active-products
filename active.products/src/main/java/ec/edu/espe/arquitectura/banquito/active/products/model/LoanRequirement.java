package ec.edu.espe.arquitectura.banquito.active.products.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class LoanRequirement {

    private String loanRequirementId;
    private String nameRequirement;
    private String description;
    private String type;
    @Version
    private Long version;

}
