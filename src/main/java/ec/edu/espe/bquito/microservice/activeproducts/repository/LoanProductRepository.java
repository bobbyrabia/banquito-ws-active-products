package ec.edu.espe.bquito.microservice.activeproducts.repository;


import ec.edu.espe.bquito.microservice.activeproducts.model.LoanProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanProductRepository extends MongoRepository<LoanProduct, String> {


}
