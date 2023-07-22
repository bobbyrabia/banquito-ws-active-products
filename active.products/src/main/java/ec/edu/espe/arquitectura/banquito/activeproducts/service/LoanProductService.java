package ec.edu.espe.arquitectura.banquito.activeproducts.service;

import ec.edu.espe.arquitectura.banquito.activeproducts.model.LoanProduct;
import ec.edu.espe.arquitectura.banquito.activeproducts.repository.LoanProductRepository;
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
