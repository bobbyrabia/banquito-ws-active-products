package ec.edu.espe.arquitectura.banquito.active.products.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Version;

@Data
@Builder
public class LoanRequirementRQ {

    private String nameRequirement;
    private String type;


}
