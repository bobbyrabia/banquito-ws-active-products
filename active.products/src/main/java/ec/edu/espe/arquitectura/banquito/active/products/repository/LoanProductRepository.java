package ec.edu.espe.arquitectura.banquito.active.products.repository;

import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanProductRepository extends MongoRepository <LoanProduct, String> {
    List<LoanProduct> findByValidIsTrue();

}
