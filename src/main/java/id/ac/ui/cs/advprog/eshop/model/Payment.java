package id.ac.ui.cs.advprog.eshop.model;

import java.util.Arrays;
import java.util.Map;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Payment {
    String id;
    String paymentMethod;
    Order order;
    Map<String, String> paymentData;
    String status;

    public Payment(String id, String paymentMethod, Order order, Map<String, String> paymentData) {
        this.id = id;
        this.setPaymentMethod(paymentMethod);


        if (paymentData == null || paymentData.isEmpty()){
            throw new IllegalArgumentException("PaymentData is Empty or null");
        } else {
            this.paymentData = paymentData;
        }

        this.setStatus(status);

        if (order == null) {
            throw new IllegalArgumentException("Order must have at least one product");
        } else {
            this.order = order;
        }
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



    public void setPaymentMethod(String method) {
        if (PaymentMethod.contains(method)) {
            this.paymentMethod = method;
        } else {
            throw new IllegalArgumentException("Invalid Payment Method");
        }
    }

}