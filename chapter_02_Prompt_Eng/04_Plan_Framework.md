
# Salesforce Selenium Framework Plan

## Understanding

Create an enterprise-oriented UI automation framework for the Salesforce login page at `https://login.salesforce.com/?locale=in`. The framework uses Java, Maven, Selenium WebDriver, and TestNG. It verifies valid and invalid login behavior, including the username, password, submit, and Remember Me controls. Because Salesforce may present an AB-tested, two-step login flow, automation must tolerate both username-first and single-page variants.

The implementation must use Page Object Model with PageFactory, `@FindBy` XPath locators only, explicit waits, TestNG lifecycle annotations, clear exception propagation, and no `Thread.sleep()`. Valid credentials must be provided externally and never committed to source control.

## Goals

- Keep tests readable, reusable, isolated, and maintainable.
- Verify login-page controls and both positive and negative login outcomes.
- Support changing login form presentation without embedding page interactions in tests.
- Capture actionable diagnostics on failure.
- Keep credentials out of source files, reports, and version control.

## Proposed Project Structure

```text
RICE_POT_SeleniumAdvanceFramework/
├── pom.xml
├── TestPlan.md
└── src/
    ├── main/java/pages/LoginPage.java
    └── test/java/
        ├── base/BaseTest.java
        └── tests/
            ├── ValidLoginTest.java
            └── InvalidLoginTest.java
```

## Implementation Plan

1. **Maven setup**
   - Configure the Java compiler, Selenium, TestNG, and Maven Surefire.
   - Use Selenium Manager for browser-driver resolution.
   - Keep dependency versions centralized as Maven properties.

2. **Shared test lifecycle**
   - Use TestNG setup hooks to validate configuration and create a fresh browser session per test.
   - Set explicit page-load and script timeouts; keep implicit wait disabled.
   - Close the browser after each test, including setup or test failures.
   - Save a screenshot in the build output directory when a test fails.

3. **Salesforce login page object**
   - Initialize elements with `PageFactory.initElements`.
   - Use `@FindBy(xpath = ...)` and XPath-based lookups only.
   - Provide reusable actions for username, password, Remember Me, and form submission.
   - Support the observed username-first AB flow and a single-page login form.
   - Verify login errors and a positive authenticated Salesforce Lightning state with explicit waits.

4. **TestNG scenarios**
   - **Valid login:** Read a dedicated account’s username and password from environment variables or Maven system properties, enable Remember Me, submit, and verify authenticated state.
   - **Invalid login:** Submit synthetic invalid credentials and verify that an error appears while the user remains unauthenticated.
   - Assert that expected login controls render before interacting with the page.

5. **Validation and operation**
   - Compile the project and run the invalid-login test independently.
   - Run the valid-login test only when a suitable Salesforce automation account is configured.
   - Review Surefire results and failure screenshots under `target/`.
   - Confirm all locator strategies are XPath and that no `Thread.sleep()` is used.

## Acceptance Criteria

- Maven clean build compiles production and test sources.
- The invalid-login test passes against the observed Salesforce login variant.
- The valid-login test passes with an authorized test account and an automation-compatible authentication policy.
- Login controls, including Remember Me, are verified.
- Every test receives a fresh WebDriver session, and teardown runs reliably.
- Failures contain clear TestNG messages and produce screenshots when possible.
- No CSS selector, direct ID/name locator API, `Thread.sleep()`, or committed credentials are present.

## Assumptions and Risks

- Salesforce may change AB variants, markup, or error behavior; locators and assertions require maintenance.
- MFA, SSO, CAPTCHA, risk-based authentication, or account policy may prevent unattended valid login.
- Valid-login behavior remains unverified until a dedicated automation account is configured.
- The URL is fixed to the requested Salesforce login page; credentials are externalized.
