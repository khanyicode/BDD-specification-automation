# BDD-specification-automation 

## Overview
Automated testing project for ParaBank web application using Selenium WebDriver, Cucumber, and Java, focusing on account management functionalities.

## Features
- **Web UI Automation** for banking application testing
- **Behavior-Driven Development (BDD)** approach
- **Page Object Model** design pattern implementation

## Technologies Used

| Technology | Description |
|-----------|-------------|
| **Language** |   Java |
| **Web Automation** | Selenium WebDriver |
| **Testing Frameworks** | Cucumber, JUnit |
| **Browser Support** | ChromeDriver |

## Prerequisites
- Java Development Kit (JDK) 8+
- Maven or Gradle
- ChromeDriver
- Selenium WebDriver
- Cucumber

## Project Setup

### Installation Steps

1. Fork the Repository
   - Navigate to the original repository on GitHub
   - Click the "Fork" button to create a copy in your GitHub account

2. Clone your forked repository
   ```bash
   git clone https://github.com/[your-username]/parabank-automation.git
   ```

3. Install dependencies
   ```bash
   mvn clean install
   ```

### Configuration
- Update `ChromeDriver` path in `BaseTest.java`
- Configure browser options as needed

## Test Execution

### Running Tests
```bash
mvn test
```

### Cucumber Options
- Use tags for specific test scenarios
- Generate detailed test reports

## Best Practices
- Use explicit waits
- Implement robust error handling
- Maintain clean page object models
- Use meaningful test data

## Troubleshooting
- Ensure ChromeDriver compatibility
- Check WebDriver version
- Verify browser configuration

## Contributing
1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create pull request


