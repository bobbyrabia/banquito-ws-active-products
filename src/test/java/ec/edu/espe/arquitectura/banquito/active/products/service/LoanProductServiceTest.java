package ec.edu.espe.arquitectura.banquito.active.products.service;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductSelectResponse;
import ec.edu.espe.arquitectura.banquito.active.products.converts.Converters;
import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import ec.edu.espe.arquitectura.banquito.active.products.repository.LoanProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoanProductServiceTest {
    @Mock
    private LoanProductRepository loanProductRepository;

    @Mock
    private Converters converters;

    @InjectMocks
    private LoanProductService loanProductService;
    @Test
    void loanProductList() {
        // Arrange
        List<LoanProduct> loanProductList = List.of(new LoanProduct());
        List<LoanProductResponse> expectedResponseList = List.of(new LoanProductResponse());
        when(loanProductRepository.findByValidIsTrue()).thenReturn(loanProductList);
        when(converters.convertLoanProductToDtoList(loanProductList)).thenReturn(expectedResponseList);

        // Act
        List<LoanProductResponse> responseList = loanProductService.loanProductList();

        // Assert
        assertEquals(expectedResponseList, responseList);
    }

    @Test
    void loanProductSelectList() {
        // Arrange
        List<LoanProduct> loanProductList = List.of(new LoanProduct());
        List<LoanProductSelectResponse> expectedResponseList = List.of(new LoanProductSelectResponse());
        when(loanProductRepository.findByValidIsTrue()).thenReturn(loanProductList);
        when(converters.convertLoanProductToDtoSelectList(loanProductList)).thenReturn(expectedResponseList);

        // Act
        List<LoanProductSelectResponse> responseList = loanProductService.loanProductSelectList();

        // Assert
        assertEquals(expectedResponseList, responseList);
    }

    @Test
    void findByIDSelected() {
        // Arrange
        String uniqueId = "someUniqueId";
        LoanProduct loanProduct = new LoanProduct();
        LoanProductSelectResponse expectedResponse = new LoanProductSelectResponse();
        when(loanProductRepository.findByValidIsTrueAndUniqueId(uniqueId)).thenReturn(Optional.of(loanProduct));
        when(converters.convertLoanProductToDtoSelect(loanProduct)).thenReturn(expectedResponse);

        // Act
        LoanProductSelectResponse response = loanProductService.FindByIDSelected(uniqueId);

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    void findByID() {
        // Arrange
        String uniqueId = "someUniqueId";
        LoanProduct loanProduct = new LoanProduct();
        LoanProductResponse expectedResponse = new LoanProductResponse();
        when(loanProductRepository.findByValidIsTrueAndUniqueId(uniqueId)).thenReturn(Optional.of(loanProduct));
        when(converters.convertLoanProductToDto(loanProduct)).thenReturn(expectedResponse);

        // Act
        LoanProductResponse response = loanProductService.FindByID(uniqueId);

        // Assert
        assertEquals(expectedResponse, response);
    }
}