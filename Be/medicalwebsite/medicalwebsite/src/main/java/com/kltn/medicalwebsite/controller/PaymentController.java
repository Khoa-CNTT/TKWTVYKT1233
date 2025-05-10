package com.kltn.medicalwebsite.controller;


import com.kltn.medicalwebsite.entity.Appointment;
import com.kltn.medicalwebsite.entity.Payment;
import com.kltn.medicalwebsite.exception.AppointmentException;
import com.kltn.medicalwebsite.repository.AppointmentRepository;
import com.kltn.medicalwebsite.repository.PaymentRepository;
import com.kltn.medicalwebsite.response.ApiResponse;
import com.kltn.medicalwebsite.response.PaymentDTO;
import com.kltn.medicalwebsite.response.ResponseObject;
import com.kltn.medicalwebsite.service.AppointmentService;
import com.kltn.medicalwebsite.service.EmailSenderService;
import com.kltn.medicalwebsite.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    private PaymentService paymentService;

    private AppointmentService appointmentService;

    private AppointmentRepository appointmentRepository;

    private PaymentRepository paymentRepository;

    private EmailSenderService emailSenderService;

    public PaymentController(PaymentService paymentService, AppointmentService appointmentService, AppointmentRepository appointmentRepository, PaymentRepository paymentRepository, EmailSenderService emailSenderService) {
        this.paymentService = paymentService;
        this.appointmentService = appointmentService;
        this.appointmentRepository = appointmentRepository;
        this.paymentRepository = paymentRepository;
        this.emailSenderService = emailSenderService;
    }

    // payment direct
    @PostMapping("/appointment/{appointmentId}")
    public ResponseEntity<Payment> paymentAppointment(@PathVariable("appointmentId")Long id , @RequestParam("amount")Double amount){
        Payment payment = paymentService.paymentAppointmentFoDoctorId(id,amount);
        return  new ResponseEntity<>(payment, HttpStatus.OK);
    }



    //payment vn-pay
    @PostMapping("/vn-pay/{appointmentId}")
    public ResponseObject<PaymentDTO.VNPayResponse> pay(HttpServletRequest request, @PathVariable Long appointmentId) throws AppointmentException {
        Long amount = null ;
        try {
            Appointment appointment = appointmentService.findAppointmentById(appointmentId);
            amount = Math.round(appointment.getConsulationSchedule().getDoctor().getExaminationPrice());
        }catch (Exception e){
            new AppointmentException("Appointment not payment with id :"+appointmentId);
        }
        return new ResponseObject<>(HttpStatus.OK, "Success", paymentService.createVnPayPayment(request,amount,appointmentId));
    }



    @GetMapping("/online/vn-pay-callback/{appointmentId}")
    public ResponseEntity<ApiResponse> payCallbackHandler(HttpServletRequest request,  @PathVariable("appointmentId") Long AppointmentId ) throws AppointmentException {
        String status = request.getParameter("vnp_ResponseCode");
        String vnp_BankTranNo = request.getParameter("vnp_BankTranNo");//ma giao dich tai ngan hang
        String vnp_TransactionNo = request.getParameter("vnp_TransactionNo"); // ma giao dich ghi nhan tai he thong vnpay
        String vnp_TransactionStatus = request.getParameter("vnp_TransactionStatus");
        Appointment appointment = appointmentService.findAppointmentById(AppointmentId);
        Payment payment = new Payment();
        payment.setAmount(appointment.getConsulationSchedule().getDoctor().getExaminationPrice());
        payment.setAppointment(appointment);
        if (status.equals("00")) {
            appointment.setStatus("CONFIRMED");
            payment.setStatus("CONFIRMED");
            payment.setVnPayLinkId(vnp_BankTranNo);
            payment.setVnPayLinkReferenceId(vnp_TransactionNo);
            payment.setVnPayLinkStatus(vnp_TransactionStatus);
            appointmentRepository.save(appointment);
            paymentRepository.save(payment);
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("Payment is  success!");
            apiResponse.setStatus(true);
            emailSenderService.sendEmail("hophuctam@dtu.edu.vn",
                    "Lịch hẹn khám bệnh cho "+ appointment.getFullName(),
                    "Lịch khám của bạn đã được chấp nhận hãy đến theo khung giờ đã đặt từ "+appointment.getConsulationSchedule().getStartTime()+"-"+appointment.getConsulationSchedule().getEndTime()+" vào ngày "+appointment.getConsulationSchedule().getDateAppointment());
            return  new ResponseEntity<>(apiResponse,HttpStatus.ACCEPTED);
        } else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
