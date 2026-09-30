import { test, expect } from '../base/BaseTest';

test.describe('VWO valid login', () => {
  test('valid credentials should login successfully', async ({ loginPage }) => {
    const email = process.env.VWO_EMAIL ?? '';
    const password = process.env.VWO_PASSWORD ?? '';

    test.skip(!email || !password, 'Set VWO_EMAIL and VWO_PASSWORD before running the valid login test.');

    await loginPage.login(email, password, true);
    await loginPage.expectDashboardVisible();
    await expect(loginPage.page).toHaveURL(/app\.vwo|dashboard|workspace|home/i, { timeout: 30000 });
  });
});
