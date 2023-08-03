package com.api.repository;

import com.api.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
  void deleteById(int id);
   Optional<Object> findById(int id);


}
