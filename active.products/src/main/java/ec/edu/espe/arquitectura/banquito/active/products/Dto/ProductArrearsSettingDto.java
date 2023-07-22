package ec.edu.espe.arquitectura.banquito.active.products.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
public class ProductArrearsSettingDto {
    private Integer defaultTolerancePeriod;
    private Integer minTolerancePeriod;
    private Integer maxTolerancePeriod;
    private Integer monthlyToleranceDay;
    private Long version;
}
