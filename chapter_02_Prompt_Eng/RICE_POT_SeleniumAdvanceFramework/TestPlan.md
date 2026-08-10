# Salesforce Login Automation Test Plan

## Objective
Validate the Salesforce login page at `https://login.salesforce.com/?locale=in` using an enterprise-grade Selenium Java framework with Maven and TestNG. The plan covers both valid and invalid login flows, UI behavior, and stability of the page object model.

## Scope
- Automate login page verification for Salesforce CRM.
- Verify valid login workflow and invalid login error handling.
- Implement reusable page object methods using PageFactory and XPath selectors only.
- Use TestNG lifecycle annotations for setup and teardown.
- Apply explicit waits and robust exception handling.
- Support external credential injection for production and staging use.

## Framework Structure
- `pom.xml`: Maven project configuration with Selenium, TestNG, and WebDriverManager dependencies.
- `src/main/java/pageobjects/LoginPage.java`: Page Object Model class with XPath-only locators and reusable actions.
- `src/test/java/tests/ValidLoginTest.java`: Valid login test script using external credentials.
- `src/test/java/tests/InvalidLoginTest.java`: Invalid login test script asserting error message visibility.
- `TestPlan.md`: This test plan document.

## Test Strategy
- Use Page Object Model with PageFactory for maintainable element abstractions.
- Avoid CSS selectors, IDs, names, and Thread.sleep().
- Prefer explicit waits via `WebDriverWait` to synchronize with page state.
- Include `@BeforeTest` and `@AfterTest` methods for browser lifecycle management.
- Handle exceptions in both page objects and tests to fail fast and provide stability.

## Test Scenarios
1. Valid Login
   - Navigate to the Salesforce login page.
   - Enter a valid username and password from system properties.
   - Select the remember me option.
   - Click login and verify redirection or page state indicates successful login.

2. Invalid Login
   - Navigate to the Salesforce login page.
   - Enter an invalid username and password.
   - Submit the login form and verify the login error message is displayed.

## Data and Configuration
- Use external system properties for valid credentials:
  - `-Dusername=<valid_username>`
  - `-Dpassword=<valid_password>`
- Hardcode invalid credentials in the invalid login test for negative validation.

## Execution
- Run tests from the framework folder using Maven:
  - `/usr/local/opt/maven/bin/mvn test -Dusername=<valid> -Dpassword=<valid>`
- Validate that both TestNG tests execute and report results.

## Deliverables
- One Page Object class: `LoginPage.java`
- Two TestNG scripts: `ValidLoginTest.java`, `InvalidLoginTest.java`
- Maven framework with `pom.xml`
- This test plan document: `TestPlan.md`
