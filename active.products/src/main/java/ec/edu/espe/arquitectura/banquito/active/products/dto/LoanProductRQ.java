package ec.edu.espe.arquitectura.banquito.active.products.dto;

import ec.edu.espe.arquitectura.banquito.active.products.model.LoanRequirement;
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
