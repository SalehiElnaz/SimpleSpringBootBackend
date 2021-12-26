package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Emploee;
import com.example.springbootbackend.repository.EmploeeRepository;
import com.example.springbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmploeeRepository emploeeRepository;

  public EmployeeServiceImpl(EmploeeRepository emploeeRepository) {
    this.emploeeRepository = emploeeRepository;
  }

  @Override
  public Emploee saveEmployee(Emploee emp) {
    return emploeeRepository.save(emp);
  }

  @Override
  public List<Emploee> getAllEmployee() {
    return emploeeRepository.findAll();
  }

  @Override
  public Emploee getById(long id) {
//    Optional<Emploee> emp=emploeeRepository.findById(id);
//    if(emp.isPresent())
//      return emp.get();
//    else
//      throw new ResourceNotFoundException("Employee","id",id);

  return emploeeRepository.findById(id).orElseThrow(() ->
                     new ResourceNotFoundException("Employee","id",id));
  }

  @Override
  public Emploee updateEmployee(Emploee emp,long id) {
     if(emploeeRepository.existsById(id)){
       Emploee newEmp =getById(id);
        newEmp.setFName(emp.getFName());
        newEmp.setLName(emp.getLName());
       return emploeeRepository.save(newEmp);

     }
     throw  new ResourceNotFoundException("Employee","id",id);
////by ramesh
//    Emploee newEmp  =emploeeRepository.findById(id).orElseThrow(() ->
//        new ResourceNotFoundException("Employee","id",id));
//    newEmp.setFName(emp.getFName());
//    newEmp.setLName(emp.getLName());
//    return emploeeRepository.save(newEmp);
  }

  @Override
  public void deleteEmp(long id) {
    Emploee existEmp  =emploeeRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Employee","id",id));
       emploeeRepository.delete(existEmp);
  }


}
