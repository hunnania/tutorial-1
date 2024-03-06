package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;

class PaymentTest {
    private Map<String, String> paymentData;
    private Order order;
    private List<Product> products;

    @BeforeEach
    void setup() {
        this.paymentData = new HashMap<>();

        products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("e45d7d21-fd29-4533-a569-abbe0819579a");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        Product product2 = new Product();
        product2.setProductId("8a76b99c-a0b3-46d2-a688-4c1831b21119");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        products.add(product2);

        order = new Order(
                "dbd4aff4-9a7f-4603-92c2-eaf529271cc9",
                products,
                1708560000L,
                "Safira Sudrajat"
        );
    }

    void loadBankTransferPaymentData() {
        paymentData.put("bankName", "BCA");
        paymentData.put("referenceCode", "1234567890");
    }

    void loadVoucherCodePaymentData() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testCreatePaymentWithDefaultStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("a3e3e3e3-9a7f-4603-92c2-eaf529271cc9", "BANK", order, paymentData);
        assertSame(order, payment.getOrder());
        assertEquals("a3e3e3e3-9a7f-4603-92c2-eaf529271cc9", payment.getId());
        assertEquals("BANK", payment.getPaymentMethod);
        assertEquals(paymentData, payment.getPaymentData);
        assertEquals("PENDING", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentEmptyPaymentData() {
        loadBankTransferPaymentData();
        this.paymentData.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("a3e3e3e3-9a7f-4603-92c2-eaf529271cc9", "BANK", order, paymentData);
        });
    }

    @Test
    void testCreatePaymentWithRejectedStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("a3e3e3e3-9a7f-4603-92c2-eaf529271cc9", "BANK", order, "REJECTED", paymentData);
        assertEquals("REJECTED", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentWithInvalidStatus() {
        loadBankTransferPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("a3e3e3e3-9a7f-4603-92c2-eaf529271cc9", "BANK", order, "MEOW", paymentData);
        });
    }

    @Test
    void testSetPaymentStatusToRejected() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("a3e3e3e3-9a7f-4603-92c2-eaf529271cc9", "BANK", order, paymentData);
        payment.setStatus("REJECTED");
        assertEquals("REJECTED", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void setPaymentStatusToInvalidStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("a3e3e3e3-9a7f-4603-92c2-eaf529271cc9", "BANK", order, "MEOW", paymentData);
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("MEOW");
        });
    }

}