package ec.edu.espe.arquitectura.banquito.active.products.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductArrearsSetting {
    private Integer defaultTolerancePeriod;
    private Integer minTolerancePeriod;
    private Integer maxTolerancePeriod;
    private Integer monthlyToleranceDay;
}
