package ec.edu.espe.arquitectura.banquito.active.products.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Product_Arrears_Setting")

public class ProductArrearsSetting {
    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueId;
    private Integer defaultTolerancePeriod;
    private Integer minTolerancePeriod;
    private Integer maxTolerancePeriod;
    private Integer monthlyToleranceDay;
    @Version
    private Long version;

}
