package ec.edu.espe.arquitectura.banquito.active.products.repository;

import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;

public interface LoanProductRepository extends MongoRepository <LoanProduct, String> {
    List<LoanProduct> findByValidIsTrue();
    Optional<LoanProduct> findByValidIsTrueAndUniqueId(String uniqueId);

}
