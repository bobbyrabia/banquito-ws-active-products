package ec.edu.espe.arquitectura.banquito.active.products.service;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductRequest;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.converts.Converters;
import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import ec.edu.espe.arquitectura.banquito.active.products.repository.LoanProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanProductService {
    private final LoanProductRepository loanProductRepository;
    private final Converters converters;


    public LoanProductService(LoanProductRepository loanProductRepository, Converters converters) {
        this.loanProductRepository = loanProductRepository;
        this.converters = converters;
    }




    public List<LoanProductResponse> loanProductList (){
        List<LoanProduct> loanProduct = loanProductRepository.findByValidIsTrue();
        List<LoanProductResponse> loanProductResponses = converters.convertLoanProductToIndicadorDtoList(loanProduct);
        return loanProductResponses;
    }









}
