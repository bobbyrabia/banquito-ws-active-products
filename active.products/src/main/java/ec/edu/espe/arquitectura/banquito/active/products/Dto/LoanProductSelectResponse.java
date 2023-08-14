package ec.edu.espe.arquitectura.banquito.active.products.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
public class LoanProductSelectResponse {
    private String uniqueId;
    private String name;
    private String description;
}
