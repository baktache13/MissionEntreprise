package tn.esprit.seancespring.services;

import org.springframework.stereotype.Service;
import tn.esprit.seancespring.entities.Product;
import tn.esprit.seancespring.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long product_id) {
        return productRepository.findById(product_id).orElse(null);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long product_id) {
        productRepository.deleteById(product_id);
    }

}