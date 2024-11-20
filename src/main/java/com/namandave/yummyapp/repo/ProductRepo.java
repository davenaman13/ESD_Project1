package com.namandave.yummyapp.repo;
import com.namandave.yummyapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price ASC LIMIT 2")
    List<Product> findTop2ByPriceBetweenOrderByPriceAsc(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
}