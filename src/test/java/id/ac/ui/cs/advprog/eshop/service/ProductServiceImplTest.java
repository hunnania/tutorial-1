package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createTest() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void findAllTest() {
        List<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList.iterator());

        List<Product> allProducts = productService.findAll();

        assertEquals(productList, allProducts);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void deleteProductByIdTest() {
        String productId = "123";

        productService.deleteProductById(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void getProductByIdTest() {
        String productId = "123";
        Product product = new Product();
        when(productRepository.findByProductId(productId)).thenReturn(product);

        Product retrievedProduct = productService.getProductById(productId);

        assertEquals(product, retrievedProduct);
        verify(productRepository, times(1)).findByProductId(productId);
    }

    @Test
    void updateProductTest() {
        Product product = new Product();

        productService.updateProduct(product);

        verify(productRepository, times(1)).updateProduct(product);
    }
}
