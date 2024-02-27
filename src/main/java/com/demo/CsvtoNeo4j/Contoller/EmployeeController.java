package com.demo.CsvtoNeo4j.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CsvtoNeo4j.Service.EmployeeService;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/upload-csv")
    public void uploadCSV() {
        String filePath = "src\\main\\java\\com\\demo\\CsvtoNeo4j\\Contoller\\employees.csv"; // Specify the actual file path
        employeeService.readAndWriteEmployeesFromCSV(filePath);
    }
}
