package com.kltn.medicalwebsite.service;


import com.kltn.medicalwebsite.entity.ConsultationSchedule;
import com.kltn.medicalwebsite.entity.Doctor;
import com.kltn.medicalwebsite.entity.MedicalType;
import com.kltn.medicalwebsite.exception.DoctorException;
import com.kltn.medicalwebsite.exception.MedicalTypeException;
import com.kltn.medicalwebsite.repository.ConsultationScheduleRepository;
import com.kltn.medicalwebsite.repository.DoctorRepository;
import com.kltn.medicalwebsite.repository.MedicalTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ConsultationScheduleServiceImlp implements ConsultationScheduleService {
    private ConsultationScheduleRepository consultationScheduleRepository;
    private DoctorRepository doctorRepository;

    public ConsultationScheduleServiceImlp(ConsultationScheduleRepository consultationScheduleRepository, DoctorRepository doctorRepository) {
        this.consultationScheduleRepository = consultationScheduleRepository;
        this.doctorRepository = doctorRepository;
    }
    @Override
    @Transactional
    public void createTimeSlot(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorException("Doctor not found: " + doctorId));

        // Lấy ngày hiện tại
        LocalDate today = LocalDate.now();

        // Xóa các khung giờ của những ngày đã qua
        consultationScheduleRepository.deleteByDoctorIdAndDateAppointmentBefore(doctorId, today);

        // Tạo khung giờ cho 7 ngày tiếp theo
        for (int i = 0; i < 7; i++) {
            LocalDate workDate = today.plusDays(i);

            // Kiểm tra xem ngày này đã có khung giờ chưa
            boolean slotsExist = consultationScheduleRepository.existsByDoctorIdAndDateAppointment(doctorId, workDate);
            if (slotsExist) {
                continue; // Bỏ qua nếu ngày đã có khung giờ
            }
            // Tạo danh sách khung giờ từ 8:00 đến 17:30, cách 30 phút, bỏ qua 11:00–13:00
            List<ConsultationSchedule> schedules = new ArrayList<>();
            LocalTime startTime = LocalTime.of(8, 0); // 8:00 AM
            LocalTime endOfDay = LocalTime.of(17, 30); // 5:30 PM
            LocalTime lunchStart = LocalTime.of(11, 0); // Bắt đầu giờ nghỉ trưa
            LocalTime lunchEnd = LocalTime.of(13, 0); // Kết thúc giờ nghỉ trưa
            while (startTime.isBefore(endOfDay)) {
                LocalTime endTime = startTime.plusMinutes(30);

                // Bỏ qua khung giờ trong khoảng 11:00–13:00
                if (!(startTime.isAfter(lunchStart.minusMinutes(1)) && startTime.isBefore(lunchEnd))) {
                    ConsultationSchedule schedule = new ConsultationSchedule();
                    schedule.setDoctor(doctor);
                    schedule.setBooked(false);
                    schedule.setStartTime(startTime);
                    schedule.setEndTime(endTime);
                    schedule.setDateAppointment(workDate);
                    schedules.add(schedule);
                }

                startTime = endTime;
            }

            // Lưu tất cả khung giờ của ngày
            consultationScheduleRepository.saveAll(schedules);
        }
    }
    @Override
    @Transactional
    @Scheduled(cron = "0 0 0 * * ?",zone = "Asia/Ho_Chi_Minh") // Chạy lúc 0:00 mỗi ngày
    public void updateTimeSlotsForAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        for (Doctor doctor : doctors) {
            createTimeSlot(doctor.getId());
        }
    }

    @Override
    @Transactional
    public void deleteTimeSlotsForDoctorsId(Long DoctorId) {
        Doctor doctor = doctorRepository.findById(DoctorId).orElseThrow(() -> new DoctorException("Doctor not found with id :"+DoctorId));
        consultationScheduleRepository.deleteByDoctorId(DoctorId);
    }

}