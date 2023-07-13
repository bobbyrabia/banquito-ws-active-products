package ec.edu.espe.arquitectura.banquito.active.products.controller;

import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import ec.edu.espe.arquitectura.banquito.active.products.service.LoanProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loanProduct")
public class LoanProductController {
     private final LoanProductService service;

    public LoanProductController(LoanProductService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<LoanProduct>> listLoandProduct(){
        List<LoanProduct> loanProducts = this.service.loanProductList();
        return ResponseEntity.ok(loanProducts);
    }

}
