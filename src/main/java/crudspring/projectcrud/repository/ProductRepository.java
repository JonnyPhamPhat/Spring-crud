package crudspring.projectcrud.repository;

import crudspring.projectcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE"
    + " CONCAT(p.name, p.brand, p.origin, p.price)"
    + " LIKE %?1%")
    public List<Product> findAll(String keyword);
}
