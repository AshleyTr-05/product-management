package com.example.productmanagement.service;

import com.example.productmanagement.entity.Product;

import java.util.List;
import java.util.Optional;
import java.math.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getProductsByCategory(String category);

    List<String> getAllCategories();

    List<Product> advancedSearch(String name, String category, BigDecimal minPrice, BigDecimal maxPrice);

    Page<Product> searchProducts(String keyword, Pageable pageable);

    Page<Product> getPaginatedProducts(Pageable pageable);

    Page<Product> getProductsByCategory(String category, Pageable pageable);

    long countProductsByCategory(String category);

    long getTotalProductCount();

    BigDecimal getTotalInventoryValue();

    BigDecimal getAverageProductPrice();

    List<Product> getLowStockProducts(int threshold);

    List<Product> getRecentProducts(int limit);
}
