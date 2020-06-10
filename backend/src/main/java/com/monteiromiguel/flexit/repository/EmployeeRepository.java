package com.monteiromiguel.flexit.repository;

import com.monteiromiguel.flexit.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Code created by: mmonteiroc
 * Email: miguelmonteiroclaveri@gmail.com
 * Github: https://github.com/mmonteiroc
 * LinkedIn: https://www.linkedin.com/in/mmonteiroc/?locale=en_US
 * Date of creation: 10/06/2020
 * Package:com.monteiromiguel.flexit.repository
 * Project: flexit-core
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByIdEmployee(Long id);
}
