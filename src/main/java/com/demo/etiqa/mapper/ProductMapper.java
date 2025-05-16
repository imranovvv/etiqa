package com.demo.etiqa.mapper;

import com.demo.etiqa.dto.ProductDTO;
import com.demo.etiqa.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductDTO dto) {
        return Product.builder()
                .bookTitle(dto.getBookTitle())
                .bookPrice(dto.getBookPrice())
                .bookQuantity(dto.getBookQuantity())
                .build();
    }

    public ProductDTO toDto(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setBookTitle(entity.getBookTitle());
        dto.setBookPrice(entity.getBookPrice());
        dto.setBookQuantity(entity.getBookQuantity());
        return dto;
    }
}
