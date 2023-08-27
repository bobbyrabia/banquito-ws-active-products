package ec.edu.espe.arquitectura.banquito.active.products.service;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductSelectResponse;
import ec.edu.espe.arquitectura.banquito.active.products.converts.Converters;
import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import ec.edu.espe.arquitectura.banquito.active.products.repository.LoanProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

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
    @DisplayName("loanProductList - Success Scenario")
    @Test
    void test_when_loanProductList_Success() {
        List<LoanProduct> loanProductList = List.of(new LoanProduct());
        List<LoanProductResponse> expectedResponseList = List.of(new LoanProductResponse());
        when(loanProductRepository.findByValidIsTrue()).thenReturn(loanProductList);
        when(converters.convertLoanProductToDtoList(loanProductList)).thenReturn(expectedResponseList);

        List<LoanProductResponse> responseList = loanProductService.loanProductList();

        assertEquals(expectedResponseList, responseList);
    }
    @DisplayName("Find By ID Selected - Success Scenario")
    @Test
    void test_when_loanProductSelectList_Success() {
        List<LoanProduct> loanProductList = List.of(new LoanProduct());
        List<LoanProductSelectResponse> expectedResponseList = List.of(new LoanProductSelectResponse());
        when(loanProductRepository.findByValidIsTrue()).thenReturn(loanProductList);
        when(converters.convertLoanProductToDtoSelectList(loanProductList)).thenReturn(expectedResponseList);

        List<LoanProductSelectResponse> responseList = loanProductService.loanProductSelectList();

        assertEquals(expectedResponseList, responseList);
    }
    @DisplayName("Find By ID Selected - Success Scenario")
    @Test
    void test_when_findByIDSelected_Success() {
        String uniqueId = "someUniqueId";
        LoanProduct loanProduct = new LoanProduct();
        loanProduct.setUniqueId("someUniqueId");
        loanProduct.setName("productMock");
        LoanProductSelectResponse expectedResponse = new LoanProductSelectResponse();
        expectedResponse.setUniqueId("someUniqueId");
        expectedResponse.setName("productMock");
        when(loanProductRepository.findByValidIsTrueAndUniqueId(uniqueId)).thenReturn(Optional.of(loanProduct));
        when(converters.convertLoanProductToDtoSelect(loanProduct)).thenReturn(expectedResponse);

        LoanProductSelectResponse response = loanProductService.FindByIDSelected(uniqueId);

        assertEquals(uniqueId, response.getUniqueId());
    }
    @DisplayName("Find By ID Selected - NotFound Scenario")
    @Test
    void test_when_FindByIDSelected_NotFound() {
        String uniqueId = "nonExistentUniqueId";

        when(loanProductRepository.findByValidIsTrueAndUniqueId(uniqueId))
                .thenReturn(Optional.empty());

        assertThrows(DataIntegrityViolationException.class, () -> {
            loanProductService.FindByIDSelected(uniqueId);
        });
    }
    @DisplayName("Find By ID Selected - Success Scenario")
    @Test
    void test_when_findByID_Success() {
        // Arrange
        String uniqueId = "someUniqueId";
        LoanProduct loanProduct = new LoanProduct();
        loanProduct.setUniqueId("someUniqueId");
        loanProduct.setName("productMock");
        LoanProductResponse expectedResponse = new LoanProductResponse();
        expectedResponse.setUniqueId("someUniqueId");
        loanProduct.setName("productMock");
        when(loanProductRepository.findByValidIsTrueAndUniqueId(uniqueId)).thenReturn(Optional.of(loanProduct));
        when(converters.convertLoanProductToDto(loanProduct)).thenReturn(expectedResponse);

        LoanProductResponse response = loanProductService.FindByID(uniqueId);

        assertEquals(expectedResponse, response);
    }
    @DisplayName("Find By ID - NotFound Scenario")
    @Test
    void test_when_FindByID_NotFound() {
        String uniqueId = "nonExistentUniqueId";

        when(loanProductRepository.findByValidIsTrueAndUniqueId(uniqueId))
                .thenReturn(Optional.empty());

        assertThrows(DataIntegrityViolationException.class, () -> {
            loanProductService.FindByID(uniqueId);
        });
    }
}