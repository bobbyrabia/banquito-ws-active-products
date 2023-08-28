package ec.edu.espe.arquitectura.banquito.active.products.controller;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductSelectResponse;
import ec.edu.espe.arquitectura.banquito.active.products.service.LoanProductService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/loanProduct")
@CrossOrigin
public class LoanProductController {
    private final LoanProductService service;

    public LoanProductController(LoanProductService service) {
        this.service = service;
    }

    @GetMapping("/productos")
    public ResponseEntity<List<LoanProductResponse>> listLoandProduct() {
        List<LoanProductResponse> loanProductResponses = service.loanProductList();
        try
        {
            return ResponseEntity.ok(loanProductResponses);
        }catch (Exception e){
            log.info("Error {}", e);
            return ResponseEntity.notFound().build();
        }
    }

        @GetMapping("/selected")
    public ResponseEntity<List<LoanProductSelectResponse>> listLoandProductSelected() {
        List<LoanProductSelectResponse> loanProductResponses = service.loanProductSelectList();
        try
        {
            return ResponseEntity.ok(loanProductResponses);
        }catch (Exception e){
            log.info("Error {}", e);
            return ResponseEntity.notFound().build();
        }
    }

        
    @GetMapping("/selected/{uniqueId}")
    public ResponseEntity<LoanProductSelectResponse> findBySelected(@PathVariable String uniqueId) {
        try {
            return ResponseEntity.ok(service.FindByIDSelected(uniqueId));
        } catch (DataIntegrityViolationException dataNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }

        @GetMapping("/productos/{uniqueId}")
    public ResponseEntity<LoanProductResponse> findByProductos(@PathVariable String uniqueId) {
        try {
            return ResponseEntity.ok(service.FindByID(uniqueId));
        } catch (DataIntegrityViolationException dataNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }


}
