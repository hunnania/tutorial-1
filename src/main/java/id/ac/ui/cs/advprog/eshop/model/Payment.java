package id.ac.ui.cs.advprog.eshop.model;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Payment {
    String id;
    String paymentMethod;
    String status;
    Order order;
    Map<String, String> paymentData;

    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
        this.id = id;
        this.paymentMethod = method;
        this.status = "PENDING";
        this.order = order;

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
    }

    public Payment(String id, String method, String status, Order order, Map<String, String> paymentData) {
        this(id, method, order, paymentData);

        String[] statusList = {"PENDING", "SUCCESS", "REJECTED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }

    public void setStatus(String status) {
        String[] statusList = {"PENDING", "ACCEPTED", "REJECTED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }
}