package tn.esprit.seancespring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.seancespring.entities.Product;
import tn.esprit.seancespring.services.ProductService;
import org.springframework.web.bind.annotation.RequestPart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;


@Component
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = {"multipart/form-data"})
    public Product save(@RequestPart("product") Product product, @RequestPart("image") MultipartFile image) {
        // save the image to the file system
        String fileName = image.getOriginalFilename();
        Path filePath = Paths.get("uploads", fileName);
        try {
            Files.write(filePath, image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // generate the image URL
        String imageUrl = filePath.toUri().toString();

        // set the imageUrl attribute of the product
        product.setImageUrl(imageUrl);

        return productService.save(product);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}