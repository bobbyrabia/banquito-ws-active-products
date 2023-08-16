package ec.edu.espe.bquito.microservice.activeproducts.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Version;

@Data
@Builder
public class LoanRequirementRQ {

    private String nameRequirement;
    private String type;


}
