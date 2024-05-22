package com.zanewnch.webmanagement;

import com.github.javafaker.Faker;
import com.zanewnch.webmanagement.mapper.EmployeeMapper;
import com.zanewnch.webmanagement.mapper.UserMapperTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.zanewnch.Employee;
import org.zanewnch.JwtUtils;
import org.zanewnch.RandomData;
import org.zanewnch.User;

@SpringBootTest
class WebManagementApplicationTests {

    private final UserMapperTest userMapper;

    private final EmployeeMapper employeeMapper;
    private final ApplicationContext applicationContext;


    @Autowired
    WebManagementApplicationTests(UserMapperTest userMapper, EmployeeMapper employeeMapper, ApplicationContext applicationContext) {
        this.userMapper = userMapper;
        this.employeeMapper = employeeMapper;
        this.applicationContext = applicationContext;
    }

    @Test
    void JwtTest() {
        /*
        Create a example Map
         */
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "zane");
        System.out.println("The claims is: " + claims);

        /*
        Generate the JWT token
         */
        String result = JwtUtils.generateJwt(claims);
        System.out.println("The JWT token is: " + result);

        /*
        Parse the JWT token
         */
        String parseResult = JwtUtils.parseJwt(result).toString();
        System.out.println("The result after parse the JWT: " + parseResult);

    }

    @Test
    void generateRandomDataTest() {

        /*
        Import the Faker library
         */
        Faker faker = new Faker();
        Random random = new Random();
        /*
        Store object
         */
        List<RandomData> randomData = new ArrayList<>();

        /*
        Generate the 10 random names
         */
        for (int i = 0; i < 10; i++) {

            String randomName = faker.name().fullName();
            int randomNumberInRange = random.nextInt(500);

            randomData.add(new RandomData(randomName, randomNumberInRange));
        }

        System.out.println(randomData);
    }

    @Test
    void generateRandomDataForProject() {
        /*
        花了一些時間debug, 因為我一開始是直接create a List<Employee> and pass it to the mapper method, but sql can not directly recognize the field of entity in the list, so the solution is cancel the list, directly instantiate the new entity in the loop and pass it to the mapper method.
         */


//        create library instance
        Faker faker = new Faker();
        Random random = new Random();

//        create random gender
        List<String> genderList = new ArrayList<>();
        genderList.add("male");
        genderList.add("female");

        for (int i = 0; i < 100; i++) {

//            The random name
            String randomName = faker.name().fullName();
//            The random number
//            there is always a chance of collusion, so the better solution is creating a method to detect whether the same number is existed in database, but I am lazy, I use the second solution is extending the range of random number, reduce the probability to generate the same number, and it is temporary success.
            int randomNumberInRange = random.nextInt(100000);
//            The random gender
            int randomNumberForGenderList = random.nextInt(genderList.size());
//            The random age
            int randomNumberForAge = random.nextInt(100) + 1;

            Employee employee = new Employee(
                    null,
                    randomName, randomNumberInRange, randomNumberForAge, genderList.get(randomNumberForGenderList),
                    LocalDateTime.now(), LocalDateTime.now()
            );

            employeeMapper.insertDataEmployee(employee);

        }


    }

    @Test
    void insertRandomDataToTable() {
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            User user = new User();

            user.setName(faker.name().fullName());

            user.setNumber(random.nextInt(500));

            user.setCreateTime(LocalDateTime.now());

            user.setUpdateTime(LocalDateTime.now());

            userMapper.insertRandomDataToTable(user);


        }
    }

    @Test
    void printCurrentSpringComponent() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }


}
