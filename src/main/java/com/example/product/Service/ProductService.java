package com.example.product.Service;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //post
    //enter product
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    //enter list of products
    public List<Product> saveAllProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //get
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    //delete
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product deleted" +id;
    }

    //update
    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setFname(product.getFname());
        existingProduct.setDescr(product.getDescr());
        existingProduct.setExpiry(product.getExpiry());
        return repository.save(existingProduct);
    }
}
