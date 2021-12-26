package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Emploee;
import com.example.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
  super();
    this.employeeService = employeeService;
  }

//  build create employee REST API
  @PostMapping
  public ResponseEntity<Emploee> saveEmp(@RequestBody Emploee emp){

    return new ResponseEntity<Emploee>(employeeService.saveEmployee(emp), HttpStatus.CREATED);
  }

  //  build get all employee REST API
  @GetMapping
  public List<Emploee> getAllEmployees(){
    return employeeService.getAllEmployee();
  }

  //  build get employee by id REST API
  //  http://localhost:8080/api/emp/1
  @GetMapping("{empid}")
  public ResponseEntity<Emploee> getEmployeeById(@PathVariable("empid") long id){
    return new ResponseEntity<Emploee>(employeeService.getById(id), HttpStatus.OK);
  }

  //  build update employee REST API
//  http://localhost:8080/api/emp/1
  @PutMapping("{id}")
  public ResponseEntity<Emploee> updateEmp(@RequestBody Emploee emp,@PathVariable("id") long id){

    return new ResponseEntity<Emploee>(employeeService.updateEmployee(emp,id), HttpStatus.OK);
  }

  //  build delete employee REST API
//  http://localhost:8080/api/emp/1
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteEmp(@PathVariable("id") long id){
    employeeService.deleteEmp(id);
    return new ResponseEntity<String>("delete Successfully!",HttpStatus.OK);
  }
}
