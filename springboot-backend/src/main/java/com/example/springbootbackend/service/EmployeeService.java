package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Emploee;

import java.util.List;

public interface EmployeeService {
  Emploee saveEmployee(Emploee emp);
  List<Emploee> getAllEmployee();
  Emploee getById(long id);
  Emploee updateEmployee(Emploee emp,long id);
  void deleteEmp(long id);

}
