package ec.edu.espe.arquitectura.banquito.active.products.service;

import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import ec.edu.espe.arquitectura.banquito.active.products.repository.LoanProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanProductService {
    private final LoanProductRepository loanProductRepository;

    public LoanProductService(LoanProductRepository loanProductRepository) {
        this.loanProductRepository = loanProductRepository;
    }
    public List<LoanProduct> loanProductList (){
        return this.loanProductRepository.findAll();
    }









}
