package com.maktab25.homework11.tamrin2.repository.base;

import com.maktab25.homework11.tamrin2.model.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee> {

    Employee findTopBySalary(String city);

    List<Employee> findAllByPostalCode(String postalCode);

    List<Employee> findAllByTelNumber(String telNumber);
}
