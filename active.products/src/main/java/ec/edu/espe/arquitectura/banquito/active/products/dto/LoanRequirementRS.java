package ec.edu.espe.arquitectura.banquito.active.products.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Version;
@Data
@Builder
public class LoanRequirementRS {
    private String loanRequirementId;
    private String nameRequirement;
    private String description;
    private String type;
    @Version
    private Long version;
}
