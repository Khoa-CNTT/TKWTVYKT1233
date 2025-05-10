package com.kltn.medicalwebsite.response;

import lombok.Builder;
import lombok.Data;

public abstract class PaymentDTO {

    @Builder
    @Data
    public static class VNPayResponse {
        public String code;
        public String message;
        public String paymentUrl;

        public VNPayResponse(String code, String message, String paymentUrl) {
            this.code = code;
            this.message = message;
            this.paymentUrl = paymentUrl;
        }
    }


}
