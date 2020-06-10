package com.monteiromiguel.flexit.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.monteiromiguel.flexit.entity.Employee;
import com.monteiromiguel.flexit.manager.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Code created by: mmonteiroc
 * Email: miguelmonteiroclaveri@gmail.com
 * Github: https://github.com/mmonteiroc
 * LinkedIn: https://www.linkedin.com/in/mmonteiroc/?locale=en_US
 * Date of creation: 10/06/2020
 * Package:com.monteiromiguel.flexit.controller
 * Project: flexit-core
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;
    @Autowired
    private Gson gson;


    /*
     * Aqui yo usaria un Set para no tener employees repetidos
     * nunca. Aun asi habria que pasar la List que nos da
     * el JpaRepo de un findAll a set. Por no rizar el
     * rizo no lo he hecho. Pero es lo que yo haria
     * */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){ return employeeManager.findAll(); }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getSpecificEmployee(@PathVariable("id") Long id){ return employeeManager.findById(id); }

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@RequestBody String json){
        JsonObject jsonObject = this.gson.fromJson(json, JsonObject.class);

        /*
        * We check we recived all required params
        * In this case the only required param was name
        * */
        if (jsonObject.get("name")==null || jsonObject.get("name").getAsString().equals(""))
            return new ResponseEntity<>("ERROR, NAME WAS EMPTY", HttpStatus.BAD_REQUEST);

        /*
        * We create the employee and the we save it
        * */
        Employee employeeToSave = new Employee();
        employeeToSave.setName(jsonObject.get("name").getAsString());

        this.employeeManager.createOrUpdate(employeeToSave);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}
