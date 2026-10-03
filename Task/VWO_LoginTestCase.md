# VWO Login Test Cases

## Verified Facts
- Task: Generate 10 test cases for the login page at https://app.vwo.com/#/login.
- The prompt includes anti-hallucination rules and a required output table format.
- No detailed functional requirements, credentials, error messages, validation rules, or success criteria were provided in the requirement section.

## Missing / Unknown Information
- Valid username and password combinations
- Exact login field labels and required fields
- Error messages for invalid credentials, empty fields, or locked accounts
- Success page or redirect destination after login
- Password policy, session timeout, forgot-password behavior, remember-me behavior, and MFA or CAPTCHA requirements
- Browser/device constraints and accessibility requirements

## Generated Output

| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |
|---|---|---|---|---|---|
| TC-01 | Open the VWO login page | User has access to the URL and a supported browser | 1. Navigate to https://app.vwo.com/#/login. 2. Wait for the page to load. | The page loads successfully and displays the login interface. If the exact UI is not specified, the expected result is: Not specified. | High |
| TC-02 | Verify login form visibility and interactivity | User is on the login page | 1. Observe the page after load. 2. Check whether the login fields and submit control are visible and usable. | The login form is visible and usable. If the exact control labels or behavior are not specified, the expected result is: Not specified. | High |
| TC-03 | Submit login form with empty username and empty password | User is on the login page | 1. Leave username empty. 2. Leave password empty. 3. Click login. | The system should handle the submission according to the provided requirements. If no requirement defines the behavior, expected result is: Not specified. | High |
| TC-04 | Submit login form with empty username | User is on the login page | 1. Leave username empty. 2. Enter a password value if available in test data. 3. Click login. | The system should reject the submission according to the provided requirements. If no requirement defines the behavior, expected result is: Not specified. | High |
| TC-05 | Submit login form with empty password | User is on the login page | 1. Enter a username value if provided by test data. 2. Leave password empty. 3. Click login. | The system should reject the submission according to the provided requirements. If no requirement defines the behavior, expected result is: Not specified. | High |
| TC-06 | Attempt login with valid credentials | Valid username and password are available in test data | 1. Enter the valid username. 2. Enter the valid password. 3. Click login. | The system should allow login only if the provided requirements define valid credentials and success behavior. Otherwise, expected result is: Not specified. | High |
| TC-07 | Attempt login with invalid credentials | Invalid username or password is available in test data | 1. Enter an invalid username or password. 2. Click login. | The system should reject the attempt according to the provided requirements. If no rejection rule is defined, expected result is: Not specified. | High |
| TC-08 | Validate malformed username input | User is on the login page and malformed username data is available | 1. Enter a malformed username value. 2. Enter a password value if required. 3. Click login. | The system should validate the username according to the provided requirements. If no validation rule is defined, expected result is: Not specified. | Medium |
| TC-09 | Validate special-character password handling | User is on the login page and special-character password data is available | 1. Enter a username. 2. Enter a password containing special characters. 3. Click login. | The system should process the value according to the provided requirements. If no rule exists for special-character handling, expected result is: Not specified. | Medium |
| TC-10 | Verify repeated login attempts | User has access to the login page and can retry login multiple times | 1. Open the login page. 2. Submit multiple login attempts using different inputs. | The system should behave according to the provided requirements for repeated attempts, including any retry or lockout policy. If not defined, expected result is: Not specified. | Medium |

## Self-Validation Check
- The test cases were generated using only the provided task input and the anti-hallucination rules.
- No undocumented feature, UI element, API, error code, or business rule was invented.
- Any missing detail was intentionally labeled as "Not specified" to avoid unsupported assumptions.
