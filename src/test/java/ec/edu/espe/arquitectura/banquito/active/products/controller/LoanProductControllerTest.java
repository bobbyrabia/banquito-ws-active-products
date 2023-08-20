package ec.edu.espe.arquitectura.banquito.active.products.controller;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductSelectResponse;
import ec.edu.espe.arquitectura.banquito.active.products.service.LoanProductService;
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
    @Test
    void listLoandProduct() {
        // Arrange
        List<LoanProductResponse> expectedResponseList = List.of(new LoanProductResponse());
        when(loanProductService.loanProductList()).thenReturn(expectedResponseList);

        // Act
        ResponseEntity<List<LoanProductResponse>> response = loanProductController.listLoandProduct();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponseList, response.getBody());
    }

    @Test
    void listLoandProductSelected() {
        // Arrange
        List<LoanProductSelectResponse> expectedResponseList = List.of(new LoanProductSelectResponse());
        when(loanProductService.loanProductSelectList()).thenReturn(expectedResponseList);

        // Act
        ResponseEntity<List<LoanProductSelectResponse>> response = loanProductController.listLoandProductSelected();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponseList, response.getBody());
    }

    @Test
    void findBySelected() {
        // Arrange
        String uniqueId = "someUniqueId";
        LoanProductSelectResponse expectedResponse = new LoanProductSelectResponse();
        when(loanProductService.FindByIDSelected(uniqueId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<LoanProductSelectResponse> response = loanProductController.findBySelected(uniqueId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }
    @Test
    void findBySelectedNotFound() {
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

    @Test
    void findByProductos() {
        // Arrange
        String uniqueId = "someUniqueId";
        LoanProductResponse expectedResponse = new LoanProductResponse();
        when(loanProductService.FindByID(uniqueId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<LoanProductResponse> response = loanProductController.findByProductos(uniqueId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }
    @Test
    void findByProductosNotFound() {
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