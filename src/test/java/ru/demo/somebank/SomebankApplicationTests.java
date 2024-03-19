package ru.demo.somebank;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = {SomebankApplicationTests.Initializer.class})
@TestPropertySource(properties = {"spring.config.location=classpath:application-properties.yml"})
class SomebankApplicationTests {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer1 = new PostgreSQLContainer<>("postgres:11.1")
            .withReuse(true)
            .withDatabaseName("account_db");

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer2 = new PostgreSQLContainer<>("postgres:11.1")
            .withReuse(true)
            .withDatabaseName("person_db");

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer3 = new PostgreSQLContainer<>("postgres:11.1")
            .withReuse(true)
            .withDatabaseName("company_db");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "ACCOUNT.USERNAME=" + postgreSQLContainer1.getUsername(),
                    "ACCOUNT.PASSWORD=" + postgreSQLContainer1.getPassword(),
                    "ACCOUNT.URL=" + postgreSQLContainer1.getJdbcUrl(),
                    "PERSON.USERNAME=" + postgreSQLContainer2.getUsername(),
                    "PERSON.PASSWORD=" + postgreSQLContainer2.getPassword(),
                    "PERSON.URL=" + postgreSQLContainer2.getJdbcUrl(),
                    "COMPANY.USERNAME=" + postgreSQLContainer3.getUsername(),
                    "COMPANY.PASSWORD=" + postgreSQLContainer3.getPassword(),
                    "COMPANY.URL=" + postgreSQLContainer3.getJdbcUrl()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
