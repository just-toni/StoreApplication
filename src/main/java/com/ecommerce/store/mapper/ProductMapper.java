package com.ecommerce.store.mapper;

import com.ecommerce.store.data.ProductDto;
import com.ecommerce.store.data.model.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToProduct(ProductDto productDto, @MappingTarget Product product);

}
