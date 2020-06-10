package com.monteiromiguel.flexit.manager;

import com.monteiromiguel.flexit.entity.Employee;
import com.monteiromiguel.flexit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Code created by: mmonteiroc
 * Email: miguelmonteiroclaveri@gmail.com
 * Github: https://github.com/mmonteiroc
 * LinkedIn: https://www.linkedin.com/in/mmonteiroc/?locale=en_US
 * Date of creation: 10/06/2020
 * Package:com.monteiromiguel.flexit.manager
 * Project: flexit-core
 */
@Service
public class EmployeeManager {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void createOrUpdate(Employee... employees) {
        Iterable<Employee> iterableEmployees = Arrays.asList(employees);
        this.employeeRepository.saveAll(iterableEmployees);
    }

    /*
     * Aqui yo usaria un Set para no tener employees repetidos
     * nunca. Aun asi habria que pasar la List que nos da
     * el JpaRepo de un findAll a set. Por no rizar el
     * rizo no lo he hecho. Pero es lo que yo haria
     * */
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return this.employeeRepository.findById(id);
    }
}
