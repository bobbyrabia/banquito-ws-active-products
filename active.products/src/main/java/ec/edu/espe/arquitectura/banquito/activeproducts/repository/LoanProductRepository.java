package ec.edu.espe.arquitectura.banquito.activeproducts.repository;

import ec.edu.espe.arquitectura.banquito.activeproducts.model.LoanProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanProductRepository extends MongoRepository <LoanProduct, String> {


}
