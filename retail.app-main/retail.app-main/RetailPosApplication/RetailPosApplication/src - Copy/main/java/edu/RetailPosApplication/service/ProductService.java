package edu.RetailPosApplication.service;
import edu.RetailPosApplication.model.Product;
import edu.RetailPosApplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public Product add(Product p) {
        return productRepo.save(p);
    }

    public Product updateStock(Long id, int newStock) {
        Product product = productRepo.findById(id).orElseThrow();
        product.setStock(newStock);
        return productRepo.save(product);
    }
}

import edu.RetailPosApplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

