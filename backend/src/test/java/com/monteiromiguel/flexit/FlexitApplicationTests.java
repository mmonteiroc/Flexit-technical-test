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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

}
