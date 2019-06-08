package com.maktab25.homework11.tamrin2;

import com.maktab25.homework11.tamrin2.repository.impl.EmployeeRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
//        Configuration configure = new Configuration();

        try (
                SessionFactory factory = new Configuration().configure().buildSessionFactory();
                Session session = factory.openSession()
        ) {
            EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(factory);
//            System.out.println(repository.findTopBySalary("Tehran"));
//            System.out.println(repository.findAllByPostalCode("158449"));
//            System.out.println(repository.findAllByTelNumber("050"));
//            repository.delete(4L);
            System.out.println(repository.findTopSalaryByCity("Tehran"));
        }

    }
}
