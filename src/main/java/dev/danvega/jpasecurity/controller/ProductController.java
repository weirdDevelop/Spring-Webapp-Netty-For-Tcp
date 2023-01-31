package dev.danvega.jpasecurity.controller;


import dev.danvega.jpasecurity.model.Product;
import dev.danvega.jpasecurity.model.Type;
import dev.danvega.jpasecurity.repository.ProductRepository;
import dev.danvega.jpasecurity.repository.TypeRepository;
import dev.danvega.jpasecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TypeRepository typeRepository;

    @GetMapping("/Get/All")
    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    @GetMapping("/Get/{id}")
    public Product getProduct(@PathVariable int id)
    {
        return productRepository.findById(id).get();
    }

    @GetMapping("/Get/Type/All")
    public List<Type> getTypes()
    {
        return typeRepository.findAll();
    }



    @PostMapping("/Add/{typeId}")
    public Product addProduct(@RequestBody Product product,@PathVariable int typeId) throws Exception {
//        Product product1=null;
//        product1=productRepository.save(product);
        Optional<Type> type=typeRepository.findById(typeId);
        if(!type.isPresent())
        {
            throw new Exception("Type not Found");
        }
        product.setType(type.get());
        return productRepository.save(product);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(product1.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
    }
    @PostMapping("/Type/Add")
    public Type addType(@RequestBody Type type)
    {
        return typeRepository.save(type);
    }

    @PutMapping("/Type/Edit/{id}")
    public Type editType(@PathVariable int id,@RequestBody Type type) throws Exception
    {
        Optional<Type> type1=typeRepository.findById(id);
        if(!type1.isPresent())
        {
            throw new Exception("Type not Found");
        }
        type.setId(id);
        typeRepository.save(type);
        return type;
    }
    @PutMapping("/Edit/{id}/{typeId}")
    public Product editProduct(@PathVariable int id,@PathVariable int typeId,
                               @RequestBody Product product) throws Exception {
        Optional<Product>product1=productRepository.findById(id);
        if(!product1.isPresent())
        {
            throw new Exception("product not found");
        }

        Optional<Type> type=typeRepository.findById(typeId);
        if(!type.isPresent())
        {
            throw new Exception("Type not Found");
        }

        product.setId(id);
        product.setType(type.get());
        return productRepository.save(product);
    }

}
