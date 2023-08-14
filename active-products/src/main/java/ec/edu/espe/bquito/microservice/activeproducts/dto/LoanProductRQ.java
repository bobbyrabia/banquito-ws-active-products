package ec.edu.espe.bquito.microservice.activeproducts.dto;

import ec.edu.espe.bquito.microservice.activeproducts.model.LoanRequirement;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class LoanProductRQ {
    private String nameProduct;
    private String description;
    private BigDecimal maxLoanAmount;
    private List<LoanRequirement> loanRequirement;
}
