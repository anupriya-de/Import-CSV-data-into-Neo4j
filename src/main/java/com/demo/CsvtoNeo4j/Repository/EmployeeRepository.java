package com.demo.CsvtoNeo4j.Repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.demo.CsvtoNeo4j.Entity.Employee;

public interface EmployeeRepository extends Neo4jRepository<Employee, Long> {
    // You can add custom query methods here if needed
}
