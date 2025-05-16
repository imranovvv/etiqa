package com.demo.etiqa.service;

import com.demo.etiqa.dto.ProductDTO;
import com.demo.etiqa.entity.Product;
import com.demo.etiqa.exception.ProductNotFoundException;
import com.demo.etiqa.mapper.ProductMapper;
import com.demo.etiqa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public Product createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        return productRepository.save(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    public Product updateProduct(Long id, ProductDTO updated) {
        return productRepository.findById(id).map(existing -> {
            existing.setBookTitle(updated.getBookTitle());
            existing.setBookPrice(updated.getBookPrice());
            existing.setBookQuantity(updated.getBookQuantity());
            return productRepository.save(existing);
        }).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
