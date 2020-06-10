package com.monteiromiguel.flexit;

import com.monteiromiguel.flexit.entity.Employee;
import com.monteiromiguel.flexit.manager.EmployeeManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlexitApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FlexitApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeManager employeeManager;
    private List<Employee> allEmployees;


    @BeforeEach
    void loadEmployees() {
        this.allEmployees = employeeManager.findAll();
    }

    @Test
    void contextLoads() {
    }

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testGetAllEmployees() {
        System.out.println("HOLA" + allEmployees);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
                HttpMethod.GET, entity, String.class);


        /*
         * Placeholder por ahora
         * */
        Assert.assertNotNull(response.getBody());
    }

    /**
     * Here we test that we can fetch a single car using its id
     */
    @Test
    public void testFindEmployeeById() {
        for (Employee toTest : this.allEmployees) {
            Employee employee = restTemplate.getForObject(getRootUrl() + "/employee/" + toTest.getIdEmployee(), Employee.class);
            Assert.assertEquals(toTest, employee);
        }
    }

    /*
     * We test that if we pass the correct params,
     * we can create an employee, if we pass wrong
     * params has to give us an error
     * */
    @Test
    public void testCreateEmployee() {
        String json = "";

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity;
        ResponseEntity<String> response;


        // BAD REQUEST - PASAMOS BODY VACIO
        entity = new HttpEntity<>(json, headers);
        response = restTemplate.exchange(getRootUrl() + "/employee",
                HttpMethod.POST, entity, String.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        // OK
        json = "{'name':'miguel'}";
        entity = new HttpEntity<>(json, headers);
        response = restTemplate.exchange(getRootUrl() + "/employee",
                HttpMethod.POST, entity, String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    public void testUpdateEmploye() {
        String json = "";

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity;
        ResponseEntity<String> response;


        // BAD REQUEST - PASAMOS BODY VACIO
        entity = new HttpEntity<>(json, headers);
        response = restTemplate.exchange(getRootUrl() + "/employee",
                HttpMethod.PUT, entity, String.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());


        // BAD REQUEST - NO PASAMOS ID
        json = "{'name':'miguel'}";
        entity = new HttpEntity<>(json, headers);
        response = restTemplate.exchange(getRootUrl() + "/employee",
                HttpMethod.PUT, entity, String.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        // OK
        json = "{'name':'" + this.allEmployees.get(0).getName() + "-MOFIDIED', 'idEmployee':" + this.allEmployees.get(0).getIdEmployee() + "}";
        entity = new HttpEntity<>(json, headers);
        response = restTemplate.exchange(getRootUrl() + "/employee",
                HttpMethod.PUT, entity, String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeleteEmlpoyee() {
        String json = "";

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity;
        ResponseEntity<String> response;


        // BAD REQUEST - PASAMOS BODY VACIO Y SIN ID
        entity = new HttpEntity<>(json, headers);
        response = restTemplate.exchange(getRootUrl() + "/employee",
                HttpMethod.DELETE, entity, String.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());


        // GOOD REQUEST
        json = "{'idEmployee':" + this.allEmployees.get(0).getIdEmployee() + "}";
        entity = new HttpEntity<>(json, headers);
        response = restTemplate.exchange(getRootUrl() + "/employee",
                HttpMethod.DELETE, entity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        int employeesLength = this.allEmployees.size();
        this.loadEmployees();
        Assert.assertEquals(employeesLength - 1, this.allEmployees.size());


    }
}
