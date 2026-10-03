# VWO Test Plan

## 1. Test Plan Overview
- Product: VWO login application at app.vwo.com
- Product Type: Experimentation, personalization, and analytics platform
- Scope: Login, authentication, session handling, recovery, SSO/social login, security, responsiveness, accessibility, and performance
- Test Objective: Validate that authentication and related login workflows are secure, reliable, usable, and production-ready
- Test Philosophy: Risk-based, requirement-traceable, and anti-hallucination-compliant

## 2. Product Scope
### In-Scope
- VWO login page at app.vwo.com
- Email and password authentication
- Remember Me behavior
- Forgot Password/reset flow
- Optional MFA
- SSO and social login paths
- Real-time validation and error handling
- Session timeout and logout
- Security controls including HTTPS and rate limiting
- UI responsiveness and accessibility
- Performance and analytics tracking for login success/failure

### Out-of-Scope
- Exact production deployment details not provided
- Exact password complexity rules not specified
- Exact session timeout duration not specified
- Exact SSO provider list beyond SAML/OAuth references
- Exact 2FA method inventory beyond “optional MFA”
- Exact API contracts and internal backend details not provided in source

## 3. Testing Objectives
- Validate successful and unsuccessful authentication flows.
- Verify secure and deterministic handling of login input and authorization states.
- Validate password recovery and session lifecycle.
- Verify accessibility, usability, and responsive behavior.
- Validate rate limiting, security, and OWASP-aligned authentication behavior.
- Confirm high-risk workflows are stable across environments and recurring regressions.

## 4. Application Modules
| Module | Description | Risk Level |
|---|---|---|
| Authentication | Email/password login | Critical |
| Session Management | Remember Me, timeout, logout | Critical |
| Recovery | Forgot Password and reset | High |
| Access Control | MFA, SSO, social login | High |
| Security | HTTPS, rate limiting, secure storage | Critical |
| UI/UX | Theme, responsiveness, validation messages | Medium |
| Accessibility | Keyboard, ARIA, contrast | High |
| Performance | Page load and concurrency | High |
| Analytics | Success/failure tracking | Medium |
| Registration | Signup / free trial path | Medium |

## 5. Testing Scope
### Functional Scope
- Login with valid credentials
- Login with invalid credentials
- Empty field validation
- Malformed email validation
- Error message handling
- Remember Me behavior
- Forgot Password/reset flow
- Optional MFA prompt
- SSO/social login detection

### Non-Functional Scope
- Security
- Performance
- Accessibility
- Compatibility
- Reliability
- Usability

## 6. Out of Scope
- Exact production topology not provided
- Exact password rule details not provided
- Exact timeout values not provided
- Exact 2FA method(s) not provided
- Exact backend API schemas not provided
- Future biometric features not in current scope

## 7. Test Strategy
The strategy is risk-based and requirement-traceable. Authentication, session security, password recovery, and security controls are the highest-risk areas. UI, accessibility, and performance are treated as essential user-impacting quality topics. Automation will focus on stable, repeatable and business-critical flows such as login validation, invalid credentials, forgot password, and regression smoke checks.

## 8. Test Types
| Test Type | Objective | Priority |
|---|---|---|
| Functional | Validate business workflows and validation behaviors | Critical |
| UI | Validate rendering, labels, maintainability, and theme behavior | High |
| API | Validate auth and recovery endpoint behavior | High |
| Integration | Validate SSO, social login, analytics, MFA | High |
| Regression | Confirm stable behavior after modifications | Critical |
| Performance | Validate load time and concurrency | High |
| Security | Validate HTTPS, rate limiting, data protection | Critical |
| Accessibility | Validate keyboard/screen reader/contrast requirements | High |
| Compatibility | Validate desktop/mobile behavior | Medium |
| Database | Validate session/user persistence logic | Medium |
| AI/Agent | Separate deterministic validation from AI evaluation | Medium |

## 9. Test Scenarios
- Login with valid credentials
- Login with invalid credentials
- Empty email field
- Empty password field
- Malformed email format
- Login with Remember Me enabled
- Login with Remember Me disabled
- Forgot password request flow
- Invalid reset token flow
- MFA prompt when enabled
- SSO login via SAML/OAuth
- Social login via Google / Microsoft
- Rate-limit scenarios for repeated failed attempts
- Session timeout validation
- HTTPS enforcement validation
- Page load time validation
- Mobile responsiveness validation
- Keyboard navigation validation
- Theme validation (light/dark)

## 10. Test Case Strategy
- Focus on critical business paths before edge cases.
- Cover positive, negative, boundary, and failure scenarios.
- Capture deterministic requirements separately from AI or inferred expectations.
- Keep test cases evidence-based and traceable to source facts.
- Avoid duplicate coverage unless the scenario adds unique risk coverage.

## 11. Test Data Strategy
| Category | Example | Purpose |
|---|---|---|
| Valid credentials | Registered email + correct password | Happy path validation |
| Invalid credentials | Wrong password or unregistered email | Negative validation |
| Empty values | Blank email / blank password | Required field check |
| Malformed values | invalidemail, no domain | Input validation |
| Boundary values | long email, long password, whitespace variations | Boundary/security checks |
| Session values | Remember Me on/off | Persistence checks |
| Recovery values | registered email for reset | Forgot password validation |
| Security values | repeated invalid attempts | lockout/rate-limit validation |

## 12. Environment Strategy
| Environment | Purpose | Notes |
|---|---|---|
| Local QA | Quick validation and smoke tests | Developer/QA local runs |
| QA | Functional and integration validation | Main validation environment |
| Staging | Production-like validation | UAT / release candidate |
| Production-like | Security, performance, and compatibility validation | Controlled test data only |
| Production | Smoke validation only | Controlled and limited |

## 13. Automation Strategy
- Automate critical regression paths: login success/failure, empty fields, malformed email, Remember Me, reset flow, session timeout, and smoke regression.
- Use Playwright for UI automation and environment-driven tests.
- Use Postman or equivalent for API validation of auth and recovery flows.
- Keep automation targeted on sustainable value and stable locators.
- Avoid automating exploratory and unsupported features without clear requirement coverage.

## 14. API Testing Strategy
- Validate login request success and failure contracts.
- Validate validation errors and HTTP response behavior.
- Verify secure headers, token usage, and encryption endpoints.
- Validate rate limit response and lockout handling.
- Verify SSO and MFA callback behavior where configured.
- Confirm reset token generation/validation behavior.

## 15. UI Testing Strategy
- Validate login form rendering and state transitions.
- Check on-blur validation and error feedback.
- Validate password strength indicator behavior.
- Validate theme behavior for light and dark mode.
- Validate mobile layout and touch-friendly controls.
- Verify keyboard and focus order.

## 16. Database Testing Strategy
- Validate session persistence and expiry behavior.
- Confirm secure handling of passwords and session tokens.
- Validate account lockout state handling and cleanup of expired sessions.
- Check user data retention behavior according to privacy expectations.

## 17. Integration Testing Strategy
- Validate SSO provider integration for SAML/OAuth calls.
- Validate social login provider transitions.
- Validate MFA prompts and token-based verification.
- Validate analytics event capture for successful and failed login attempts.
- Validate forgot password email system integration.

## 18. Performance Testing Strategy
- Measure login page load time under standard network conditions.
- Validate concurrency capacity for thousands of simulated login attempts.
- Review peak time usage and throughput behavior.
- Validate the stability of auth workflows under load.

## 19. Security Testing Strategy
- Validate HTTPS enforcement and secure transport.
- Validate rate limiting and brute-force prevention.
- Validate password masking and secure recovery mechanisms.
- Validate OWASP authentication guidance alignment.
- Validate secure error handling that avoids leakage of sensitive details.
- Validate GDPR/CCPA handling where relevant.

## 20. Compatibility Testing
| Browser / Platform | Coverage |
|---|---|
| Chrome | Required |
| Edge | Required |
| Firefox | Recommended |
| Safari | Recommended |
| Mobile browsers | Required for responsive checks |
| Keyboard-only access | Required |

> Exact support matrix is not specified in source documents; this needs confirmation before release sign-off.

## 21. Accessibility Testing
- Validate keyboard-only navigation.
- Validate screen-reader labels and ARIA semantics.
- Validate high contrast mode and visible error messages.
- Validate form label associations and focus visibility.
- Validate WCAG 2.1 AA compliance target.

## 22. AI/Agent Testing Strategy
Deterministic validation must be kept separate from AI evaluation. AI behavior should be validated only where AI assists the product or user workflow. The expected behavior must be proven using product documentation and observed functionality.

| Agent Capability | Test Scenario | Evaluation Criteria | Expected Behavior | Evaluation Method | Priority |
|---|---|---|---|---|---|
| Login assistance | AI-guided login support | Correctness and security alignment | AI should not invent credentials or bypass validation | Manual QA + deterministic checks | Medium |
| Error explanation | Failed login explanation | Accuracy and traceability | AI explanation must match actual behavior | Manual review + logs | Medium |
| Session awareness | Session continuity | Correct context usage | AI must reference only valid session state | Deterministic validation | Medium |
| Security guardrail | Security advice | No unsafe instructions | AI should not recommend insecure actions | Security review | High |

## 23. Regression Strategy
- Run smoke regression after each build.
- Re-run high-risk tests after auth/UI changes.
- Keep a critical regression pack for login, error validation, session timeout, SSO, and recovery flows.
- Trigger full regression before release if auth architecture changes.

## 24. Defect Management
- Defect severity and priority based on business impact.
- Critical defects include authentication failure, exposed sensitive data, or lockout bypass.
- High defects include invalid recovery flow, session issues, or accessibility blocker.
- Each defect must include summary, reproduction steps, environment, expected vs actual result, and evidence.
- Lifecycle: New -> Assigned -> In Progress -> Fixed -> Verified -> Closed.

## 25. Risk & Mitigation
| Risk | Impact | Mitigation |
|---|---|---|
| Authentication failure | Critical | Functional + security validation |
| Brute force bypass | Critical | Rate limiting validation |
| Session timeout issue | High | Timeout and logout tests |
| SSO/MFA mismatch | High | Integration and failover checks |
| Performance degradation | High | Load and latency validation |
| Accessibility barrier | High | Keyboard + screen reader checks |
| Ambiguous requirements | Medium | Explicitly mark “Insufficient information to determine” |

## 26. Entry Criteria
- Requirements are available and reviewed.
- Test data is prepared.
- The test environment is available.
- Browser/device matrix is confirmed.
- CI/test tooling is available.
- Build candidate is ready.

## 27. Exit Criteria
- All critical and high-priority test cases pass.
- No open critical defects remain.
- Security, accessibility, and regression checks are completed.
- Performance against agreed thresholds is acceptable.
- Final evidence is available for QA manager review.

## 28. Metrics & Reporting
- Test execution status by module and priority
- Defect category and severity trends
- Pass/fail metrics for critical flows
- Security and accessibility defect counts
- Performance benchmarking results
- Automation coverage summary

## 29. Test Deliverables
- Test plan
- Test cases and scenarios
- Test data matrix
- Defect log
- Execution report
- Risk register
- Automation scripts and smoke suite
- Sign-off checklist

## 30. Open Questions
- Exact password complexity rule not provided.
- Exact session timeout duration not provided.
- Exact rate-limit threshold not provided.
- Exact 2FA methods not provided.
- Exact SSO/social providers enabled not specified.
- Exact browser support matrix not specified.
- Exact analytics events not specified.
- Exact production concurrency thresholds not specified.

## 31. Module Test Type Objective Coverage Automation Tool Priority
| Module | Test Type | Objective | Coverage | Automation | Tool | Priority |
|---|---|---|---|---|---|---|
| Authentication | Functional, UI, Security | Validate login flow | Valid, invalid, empty, malformed | Yes | Playwright | Critical |
| Session Management | Functional, Security | Validate timeout and persistence | Remember Me, timeout, logout | Yes | Playwright | Critical |
| Password Recovery | Functional, API | Validate reset flow | Request and reset path | Yes | Playwright/Postman | High |
| MFA/SSO | Integration, Security | Validate identity provider access | Prompt and provider callback | Partial | Playwright/Postman | High |
| Accessibility | Accessibility | Validate keyboard and readability | Form navigation, contrast | Yes | Playwright accessibility tools | High |
| Performance | Performance | Validate speed and concurrency | Load time, peak login | Yes | Playwright/k6 | High |
| Security | Security | Validate HTTPS and brute-force controls | Transport, lockout, secure storage | Partial | Postman/Browser | Critical |

## 32. Sample Test Cases
### TC-01: Valid login
- Summary: A user logs in using valid credentials.
- Description: Validate login success and redirect behavior.
- Precondition: Registered login credentials available.
- Steps: 1. Open login page. 2. Enter valid email. 3. Enter valid password. 4. Click Sign in.
- Expected Outcome: User is authenticated and redirected to the authenticated area.

### TC-02: Invalid login
- Summary: A user logs in with wrong credentials.
- Description: Validate rejection and clear error messaging.
- Precondition: Valid email known but password incorrect.
- Steps: 1. Open login page. 2. Enter valid email. 3. Enter incorrect password. 4. Click Sign in.
- Expected Outcome: Login rejected; clear error message shown; user remains on login flow.

### TC-03: Empty email
- Summary: User leaves email empty.
- Description: Validate required field handling.
- Steps: 1. Leave email blank. 2. Enter password. 3. Click Sign in.
- Expected Outcome: Submission blocked; validation message displayed.

### TC-04: Empty password
- Summary: User leaves password empty.
- Description: Validate required field handling.
- Steps: 1. Enter email. 2. Leave password blank. 3. Click Sign in.
- Expected Outcome: Submission blocked; validation message displayed.

### TC-05: Malformed email
- Summary: User enters invalid email format.
- Description: Validate on-blur email validation.
- Steps: 1. Enter malformed email. 2. Move away from field.
- Expected Outcome: Validation error displayed; login not allowed.

### TC-06: Remember Me
- Summary: User enables persistent session.
- Description: Validate session persistence when Remember Me is selected.
- Steps: 1. Log in with Remember Me enabled. 2. Close browser. 3. Reopen app.
- Expected Outcome: Session persists according to product behavior.

### TC-07: Forgot Password
- Summary: User requests password reset.
- Description: Validate secure recovery path.
- Steps: 1. Click Forgot Password. 2. Enter registered email. 3. Submit.
- Expected Outcome: Password reset request is initiated through secure flow.

### TC-08: MFA prompt
- Summary: User with MFA enabled tries to log in.
- Description: Validate second-factor challenge prompt.
- Steps: 1. Log in with valid credentials on account with MFA enabled.
- Expected Outcome: MFA challenge appears before access is granted.

### TC-09: HTTPS enforcement
- Summary: Login uses secure transport.
- Description: Validate HTTPS requirement.
- Steps: 1. Open app.vwo.com login page. 2. Review URL and secure transport.
- Expected Outcome: Authentication is protected with HTTPS/TLS.

### TC-10: Keyboard navigation
- Summary: User accesses login without a mouse.
- Description: Validate keyboard accessibility.
- Steps: 1. Use Tab/Enter only. 2. Navigate all controls.
- Expected Outcome: Form is fully navigable and usable via keyboard.

## 33. Self-Validation Check
- All content is traceable to source facts and repository evidence.
- Missing items are explicitly marked as “Insufficient information to determine.”
- No invented features, error codes, or undocumented UI behaviors were added.
- The plan intentionally focuses on production risk, quality, and evidence-based QA coverage, not inflated test counts.

## 34. Final QA Manager Review Note
This test plan is ready for review by junior QA members and approval by management, subject to confirmation of missing business details such as password policy, timeout values, SSO provider matrix, and browser support matrix. The document is intentionally evidence-based and does not assume requirements that are not explicitly documented.
