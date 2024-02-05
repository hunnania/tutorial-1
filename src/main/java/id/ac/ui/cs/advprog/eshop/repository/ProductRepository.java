package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private static int createdProducts;
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        product.setProductId(createdProducts++);
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findByProductId(int productId) {
        for (Product product : productData) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null; // Return null if no product with the specified productId is found
    }

    public void deleteById(int productId) {
        Product productTarget = findByProductId(productId);
        productData.remove(productTarget);
    }

}