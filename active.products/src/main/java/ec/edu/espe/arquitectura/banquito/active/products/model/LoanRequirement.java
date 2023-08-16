package ec.edu.espe.arquitectura.banquito.active.products.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Version;
@NoArgsConstructor
@Data
public class LoanRequirement {
    private String name;
    private String description;
    private String type;
    private String documentation;
    @Version
    private Long version;

}
