package ec.edu.espe.bquito.microservice.activeproducts.model;

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
