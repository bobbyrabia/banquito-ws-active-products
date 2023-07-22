package ec.edu.espe.arquitectura.banquito.active.products.controller;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.service.LoanProductService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/loanProduct")
public class LoanProductController {
    private final LoanProductService service;

    public LoanProductController(LoanProductService service) {
        this.service = service;
    }

    @GetMapping("productos")
    public ResponseEntity<List<LoanProductResponse>> listLoandProduct() {
        List<LoanProductResponse> loanProductResponses = service.loanProductList();
        try
        {
            return ResponseEntity.ok(loanProductResponses);
        }catch (Exception e){
            log.info("Error {}", e);
            return ResponseEntity.ok(loanProductResponses);
        }
    }

}
