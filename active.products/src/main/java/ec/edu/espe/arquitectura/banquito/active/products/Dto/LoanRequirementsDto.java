package ec.edu.espe.arquitectura.banquito.active.products.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter 
@Getter 
@NoArgsConstructor
public class LoanRequirementsDto {
    private String name;
    private String description;
    private String type;
    private String documentation;
    private Long version;  
}
