package dev.danvega.jpasecurity.Service;


import dev.danvega.jpasecurity.ModelDtos.ProductDto;

import java.util.concurrent.ConcurrentHashMap;

public class ProductMap {
    private static ConcurrentHashMap<String, ProductDto> productHashMap=new ConcurrentHashMap<>();
    public static void put(ProductDto productDto)
    {
        productHashMap.put(productDto.getMacId(),productDto);
    }

    public static void get(ProductDto productDto)
    {
        productHashMap.get(productDto.getMacId());
    }

    public static void remove(ProductDto productDto)
    {
        productHashMap.remove(productDto.getMacId());
    }

    public static ConcurrentHashMap<String, ProductDto> getProductHashMap() {
        return productHashMap;
    }
}
