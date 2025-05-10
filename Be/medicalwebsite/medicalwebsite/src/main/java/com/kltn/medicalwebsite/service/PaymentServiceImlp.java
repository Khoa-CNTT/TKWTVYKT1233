package com.kltn.medicalwebsite.service;

import com.kltn.medicalwebsite.entity.Appointment;
import com.kltn.medicalwebsite.entity.Payment;
import com.kltn.medicalwebsite.exception.AppointmentException;
import com.kltn.medicalwebsite.repository.AppointmentRepository;
import com.kltn.medicalwebsite.repository.PaymentRepository;
import com.kltn.medicalwebsite.response.PaymentDTO;
import com.kltn.medicalwebsite.util.VnPayUtil;
import com.kltn.medicalwebsite.webconfig.VNPayConfig;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PaymentServiceImlp implements PaymentService {

    private AppointmentRepository appointmentRepository;

    private PaymentRepository paymentRepository;

    private VNPayConfig paymentConfig;


    public PaymentServiceImlp(AppointmentRepository appointmentRepository, PaymentRepository paymentRepository, VNPayConfig paymentConfig) {
        this.appointmentRepository = appointmentRepository;
        this.paymentRepository = paymentRepository;
        this.paymentConfig = paymentConfig;
    }


    @Override
    public Payment paymentAppointmentFoDoctorId(Long appointment, Double amount) {
        Optional<Appointment> exsitAppointment = appointmentRepository.findById(appointment);
        if (exsitAppointment.isPresent()) {
            Payment payment = new Payment();
            payment.setAppointment(exsitAppointment.get());
            payment.setAmount(amount);
            payment.setStatus("PENDING");
            return paymentRepository.save(payment);
        } else {
            throw new AppointmentException("can't pay cause appointment not found with id :" + appointment);
        }

    }

    @Override
    public Payment findPaymentById(Long id) {
        Optional<Payment> existAppointment = paymentRepository.findById(id);
        if (existAppointment.isPresent()) {
            return existAppointment.get();
        }
        throw new RuntimeException("payment not found with id :" + id);
    }

    @Override
    public PaymentDTO.VNPayResponse createVnPayPayment(HttpServletRequest request, Long amount, Long appointmentId) {
        long money = amount * 100L;
//        String bankCode = request.getParameter("bankCode");
        Map<String, String> vnpParamsMap = paymentConfig.getVnPayConfig(appointmentId);
        vnpParamsMap.put("vnp_Amount", String.valueOf(money));
        vnpParamsMap.put("vnp_BankCode", "NCB");
        vnpParamsMap.put("vnp_IpAddr", VnPayUtil.getIpAddress(request));
        //build query url
        String queryUrl = VnPayUtil.getPaymentURL(vnpParamsMap, true);
        String hashData = VnPayUtil.getPaymentURL(vnpParamsMap, false);
        String vnpSecureHash = VnPayUtil.hmacSHA512(paymentConfig.getSecretKey(), hashData);

        queryUrl += "&vnp_SecureHash=" + vnpSecureHash;

        String paymentUrl = paymentConfig.getVnp_PayUrl() + "?" + queryUrl;
        return PaymentDTO.VNPayResponse.builder()
                .code("ok")
                .message("success")
                .paymentUrl(paymentUrl).build();
    }
}
