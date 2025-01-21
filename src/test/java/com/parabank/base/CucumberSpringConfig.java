package com.parabank.base;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)  // This replaces @Configuration
public class CucumberSpringConfig extends BaseTest {
    // Configuration will go in TestConfig class
}