import dao.impl.DoctorDaoImpl;
import dao.impl.HospitalDaoImpl;
import database.Database;
import enums.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        System.out.println("=========DOCTOR=========");
        Database database = new Database();
        HospitalDaoImpl hospitalDao = new HospitalDaoImpl();
        Hospital hospital = new Hospital();

        DoctorDaoImpl doctorDao = new DoctorDaoImpl(database);

        Doctor doctor1 = new Doctor(1L, "Nurseyit", "Sadirov", Gender.MALE, 2021);
        Doctor doctor = new Doctor(2L, "Ernazar", "Tilek uulu", Gender.MALE, 2022);

        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.addDoctorToHospital(1L, doctor1));
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.findDoctorById(1L));
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.updateDoctor(1L, doctor));
        System.out.println("~~~~~~~~~~~~~");
        doctorDao.deleteDoctorById(1L);
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.assignDoctorToDepartment(1L, List.of(211L, 24352L)));
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.getAllDoctorsByHospitalId(1L));
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.getAllDoctorsByDepartmentId(1L));
        System.out.println("~~~~~~~~~~~~~");

        System.out.println("=============HOSPITAL============");
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(22L, "Nurseyit", "Sadirov", Gender.MALE, 2006));
        doctors.add(new Doctor(23L, "Adilet", "Islamber uulu", Gender.MALE, 2001));
        doctors.add(new Doctor(24L, "Aizat", "Dyisheeva", Gender.FEMALE, 2003));
        doctors.add(new Doctor(25L, "Baitik", "Taalaibekov", Gender.MALE, 2002));
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(12L, "Nurseyit", doctors));
        departments.add(new Department(13L, "Khafiz", doctors));
        departments.add(new Department(14L, "Mirbek", doctors));
        departments.add(new Department(15L, "Matmusa", doctors));
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(33L, "Ernazar", "Tilek uulu", 20, Gender.MALE));
        List<Hospital> hospitals = List.of(
                new Hospital(2L, "Urology", "Vostok 5", departments, doctors, patients),
                new Hospital(3L, "Urology", "Vostok 5", departments, doctors, patients),
                new Hospital(4L, "Urology", "Vostok 5", departments, doctors, patients)
        );

        Hospital hospital = new Hospital(1L, "Urology", "Vostok 5", departments, doctors, patients);

        HospitalDaoImpl hospitalDao = new HospitalDaoImpl();
        System.out.println(hospitalDao.addHospital(hospital));
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao.findHospitalById(34L));
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao.getAllHospital());
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao.getAllPatientFromHospital(1L));
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao.deleteHospitalById(2L));
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao.getAllHospitalByAddress("Vostok 5"));

    }
}