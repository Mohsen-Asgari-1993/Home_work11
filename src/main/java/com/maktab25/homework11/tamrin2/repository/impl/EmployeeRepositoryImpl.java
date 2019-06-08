package com.maktab25.homework11.tamrin2.repository.impl;

import com.maktab25.homework11.tamrin2.model.Employee;
import com.maktab25.homework11.tamrin2.repository.base.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements EmployeeRepository {

    private SessionFactory factory;

    public EmployeeRepositoryImpl(SessionFactory factory) {
        super(factory);
        this.factory = factory;
    }

    @Override
    public String getEntityName() {
        return "Employee";
    }

    @Override
    public Employee findTopBySalary(String city) {
        Session session = factory.openSession();

        Employee employee1 = session.createQuery("select e from Employee e where e.salary = " +
                "(select max (e.salary) from Employee e , Address a where e.id = a.employee.id and a.city = ?1 ) ", Employee.class)
                .setParameter(1, city).getSingleResult();

        return employee1;
    }

    @Override
    public Long findTopSalaryByCity(String city) {
        Session session = factory.openSession();

        Long salary = session.createQuery("select max(e.salary) from Employee e , Address a where a.city = ?1", Long.class)
                .setParameter(1, city).getSingleResult();
        return salary;

    }

    @Override
    public List<Employee> findAllByPostalCode(String postalCode) {
        Session session = factory.openSession();
        List<Employee> list = session.createQuery("select e from Employee e , Address a " +
                "where e.id = a.employee.id " +
                "and a.postalCode = ?1 group by e", Employee.class)
                .setParameter(1, postalCode)
                .list();
        return list;
    }

    @Override
    public List<Employee> findAllByTelNumber(String telNumber) {
        Session session = factory.openSession();
//

        List<Employee> list1 = session.createQuery("select e from Employee e " +
                "join e.addresses a " +
                "join a.numbers n " +
                "where n.telNumber=?1", Employee.class)
                .setParameter(1, telNumber)
                .list();
        return list1;
    }
}
