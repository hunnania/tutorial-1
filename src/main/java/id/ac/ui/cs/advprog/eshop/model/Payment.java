package id.ac.ui.cs.advprog.eshop.model;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

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
        this.setPaymentMethod(method);
        this.setStatus(status);

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }

        if (order == null) {
            throw new IllegalArgumentException("Order must have at least one product");
        } else {
            this.order = order;
        }
    }

    public boolean isValidBankTransfer() {
        if (this.paymentData.containsKey("bankName") &&
                this.paymentData.containsKey("referenceCode") ){
            if (paymentData.get("bankName")!= null){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isValidVoucherCode(String voucherCode) {
        if (voucherCode.length() != 16) {
            return false;
        }
        if (!voucherCode.startsWith("ESHOP")) {
            return false;
        }
        String numericalPart = voucherCode.substring(5, 15);
        if (!numericalPart.matches("\\d{8}")) {
            return false;
        }
        return true;
    }

    public void setStatus(String status) {
        if (this.paymentMethod.equals("BANK_TRANSFER")){
            if (isValidBankTransfer()){
                this.status = PaymentStatus.SUCCESS.getValue();
            } else {
                this.status = PaymentStatus.REJECTED.getValue();
            }
        } else {
            if (paymentData.containsKey("voucherCode")){
                if (isValidVoucherCode(paymentData.get("voucherCode"))){
                    this.status = PaymentStatus.SUCCESS.getValue();
                } else {
                    this.status = PaymentStatus.REJECTED.getValue();
                }
            } else {
                this.status = PaymentStatus.REJECTED.getValue();
            }

        }
    }

    public void setPaymentMethod(String method) {
        if (PaymentMethod.contains(method)) {
            this.paymentMethod = method;
        } else {
            throw new IllegalArgumentException("Invalid Payment Method");
        }
    }
}