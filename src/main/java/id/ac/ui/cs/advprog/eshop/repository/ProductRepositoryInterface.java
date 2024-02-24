package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.Iterator;

public interface ProductRepositoryInterface {
    public Product create(Product product);
    public Iterator<Product> findAll();
    public Product findByProductId(String productId);
    public void deleteById(String productId);
    public void updateProduct(Product updatedProduct);
}