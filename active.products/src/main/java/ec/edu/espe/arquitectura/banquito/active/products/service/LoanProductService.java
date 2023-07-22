package ec.edu.espe.arquitectura.banquito.active.products.service;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductRequest;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductSelectResponse;
import ec.edu.espe.arquitectura.banquito.active.products.converts.Converters;
import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import ec.edu.espe.arquitectura.banquito.active.products.repository.LoanProductRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<LoanProductResponse> loanProductResponses = converters.convertLoanProductToDtoList(loanProduct);
        return loanProductResponses;
    }


    public List<LoanProductSelectResponse> loanProductSelectList (){
        List<LoanProduct> loanProduct = loanProductRepository.findByValidIsTrue();
        List<LoanProductSelectResponse> loanProductSelectResponses = converters.convertLoanProductToDtoSelectList(loanProduct);
        return loanProductSelectResponses;
    }


    public LoanProductSelectResponse FindByIDSelected(String uniqueId) {
        Optional<LoanProduct> loan_productOpt = loanProductRepository.findByValidIsTrueAndUniqueId(uniqueId);
        if (loan_productOpt.isPresent()) {

            LoanProductSelectResponse loanProductSelectResponse = converters.convertLoanProductToDtoSelect(loan_productOpt.get());
            return loanProductSelectResponse;
        } else {
            throw new DataIntegrityViolationException(
                    "El no existe el producto con la clave unica:  " + uniqueId );

        }
    }


    public LoanProductResponse FindByID(String uniqueId) {
        Optional<LoanProduct> loan_productOpt = loanProductRepository.findByValidIsTrueAndUniqueId(uniqueId);
        if (loan_productOpt.isPresent()) {

            LoanProductResponse loanProductResponse = converters.convertLoanProductToDto(loan_productOpt.get());
            return loanProductResponse;
        } else {
            throw new DataIntegrityViolationException(
                    "El no existe el producto con la clave unica:  " + uniqueId );

        }
    }


}
