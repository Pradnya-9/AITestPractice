import { test, expect } from '../base/BaseTest';

test.describe('VWO invalid login', () => {
  test('invalid credentials should show an error', async ({ loginPage }) => {
    await loginPage.login('invalid.user@example.com', 'WrongPassword123!', false);
    await loginPage.expectErrorVisible();
    await expect(loginPage.page).toHaveURL(/login|app\.vwo/i, { timeout: 20000 });
  });
});
