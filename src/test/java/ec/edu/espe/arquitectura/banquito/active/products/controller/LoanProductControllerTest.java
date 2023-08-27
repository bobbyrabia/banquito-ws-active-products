package ec.edu.espe.arquitectura.banquito.active.products.controller;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductSelectResponse;
import ec.edu.espe.arquitectura.banquito.active.products.service.LoanProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoanProductControllerTest {
    @Mock
    private LoanProductService loanProductService;

    @InjectMocks
    private LoanProductController loanProductController;

    @DisplayName("listLoandProduct - Success Scenario")
    @Test
    void test_when_listLoandProduct_Success() {
        // Arrange
        List<LoanProductResponse> expectedResponseList = List.of(new LoanProductResponse());
        when(loanProductService.loanProductList()).thenReturn(expectedResponseList);

        // Act
        ResponseEntity<List<LoanProductResponse>> response = loanProductController.listLoandProduct();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponseList, response.getBody());
    }

    @DisplayName("listLoandProductSelected - Success Scenario")
    @Test
    void test_when_listLoandProductSelected_Success() {
        // Arrange
        List<LoanProductSelectResponse> expectedResponseList = List.of(new LoanProductSelectResponse());
        when(loanProductService.loanProductSelectList()).thenReturn(expectedResponseList);

        // Act
        ResponseEntity<List<LoanProductSelectResponse>> response = loanProductController.listLoandProductSelected();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponseList, response.getBody());
    }
    @DisplayName("findBySelected - Success Scenario")
    @Test
    void test_when_findBySelected_Success() {
        // Arrange
        String uniqueId = "someUniqueId";
        LoanProductSelectResponse expectedResponse = new LoanProductSelectResponse();
        expectedResponse.setUniqueId("someUniqueId");
        expectedResponse.setName("productMock");
        when(loanProductService.FindByIDSelected(uniqueId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<LoanProductSelectResponse> response = loanProductController.findBySelected(uniqueId);
        System.out.println(response.getBody().getName());
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(uniqueId, response.getBody().getUniqueId());
    }
    @DisplayName("findBySelected - Success Scenario")
    @Test
    void test_when_findBySelected_NotFound() {
        // Arrange
        String uniqueId = "nonExistentUniqueId";
        when(loanProductService.FindByIDSelected(uniqueId))
                .thenThrow(new DataIntegrityViolationException("Product not found"));

        // Act
        ResponseEntity<LoanProductSelectResponse> response = loanProductController.findBySelected(uniqueId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @DisplayName("findByProductos - Success Scenario")
    @Test
    void test_when_findByProductos_Success() {
        // Arrange
        String uniqueId = "someUniqueId";
        LoanProductResponse expectedResponse = new LoanProductResponse();
        expectedResponse.setUniqueId("someUniqueId");
        expectedResponse.setName("productMock");
        when(loanProductService.FindByID(uniqueId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<LoanProductResponse> response = loanProductController.findByProductos(uniqueId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(uniqueId, response.getBody().getUniqueId());
    }
    @DisplayName("findByProductos - Success Scenario")
    @Test
    void test_when_findByProductos_NotFound() {
        // Arrange
        String uniqueId = "nonExistentUniqueId";
        when(loanProductService.FindByID(uniqueId))
                .thenThrow(new DataIntegrityViolationException("Product not found"));

        // Act
        ResponseEntity<LoanProductResponse> response = loanProductController.findByProductos(uniqueId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
}