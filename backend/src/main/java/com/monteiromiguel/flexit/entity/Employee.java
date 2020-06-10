package com.monteiromiguel.flexit.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Code created by: mmonteiroc
 * Email: miguelmonteiroclaveri@gmail.com
 * Github: https://github.com/mmonteiroc
 * LinkedIn: https://www.linkedin.com/in/mmonteiroc/?locale=en_US
 * Date of creation: 10/06/2020
 * Package:com.monteiromiguel.flexit.entity
 * Project: flexit-core
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemployee")
    private Long idEmployee;

    @Column(name = "name")
    private String name;

    @Column(name = "last_event_date")
    private LocalDate lastEventDate;

    public Employee() {
    }


    /*
     * Getters & Setters
     * */

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLastEventDate() {
        return lastEventDate;
    }

    public void setLastEventDate(LocalDate lastEventDate) {
        this.lastEventDate = lastEventDate;
    }


    /*
     * Hacemos un equals sin el id para
     * poder comparar los employees en los tests
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(lastEventDate, employee.lastEventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastEventDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", name='" + name + '\'' +
                ", lastEventDate=" + lastEventDate +
                '}';
    }
}
