package ec.edu.espe.bquito.microservice.activeproducts.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class LoanRequirement {

    private String nameRequirement;
    private String description;
    private String type;


}
