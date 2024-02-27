package com.demo.CsvtoNeo4j.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.CsvtoNeo4j.Entity.Employee;
import com.demo.CsvtoNeo4j.Repository.EmployeeRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional
    public void readAndWriteEmployeesFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee employee = new Employee();
                employee.setEmpId(data[0]);
                employee.setFirstName(data[1]);
                employee.setLastName(data[2]);
                employee.setEmail(data[3]);
                repository.save(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
