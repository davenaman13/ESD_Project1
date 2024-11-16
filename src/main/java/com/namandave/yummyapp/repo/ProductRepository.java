package com.namandave.yummyapp.repo;

import com.namandave.yummyapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query to fetch top 2 products within price range 15 to 30, ordered by price
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price ASC")
    List<Product> findTop2ByPriceBetweenOrderByPrice(double minPrice, double maxPrice);
}
