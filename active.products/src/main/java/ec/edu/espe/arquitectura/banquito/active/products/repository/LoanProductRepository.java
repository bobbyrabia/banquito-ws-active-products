package ec.edu.espe.arquitectura.banquito.active.products.repository;

import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoanProductRepository extends MongoRepository <LoanProduct, String> {


}
