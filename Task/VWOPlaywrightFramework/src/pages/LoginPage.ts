import { expect, Locator, Page } from '@playwright/test';

export class LoginPage {
  readonly page: Page;
  readonly emailInput: Locator;
  readonly passwordInput: Locator;
  readonly rememberMeCheckbox: Locator;
  readonly signInButton: Locator;
  readonly errorBanner: Locator;

  constructor(page: Page) {
    this.page = page;
    this.emailInput = page.locator("xpath=(//form[contains(@class,'login') or contains(@id,'login') or contains(@name,'login')]//input[@type='email'])[1]");
    this.passwordInput = page.locator("xpath=(//form[contains(@class,'login') or contains(@id,'login') or contains(@name,'login')]//input[@type='password'])[1]");
    this.rememberMeCheckbox = page.locator("xpath=(//form[contains(@class,'login') or contains(@id,'login') or contains(@name,'login')]//input[@type='checkbox'])[1]");
    this.signInButton = page.locator("xpath=(//form[contains(@class,'login') or contains(@id,'login') or contains(@name,'login')]//button[contains(normalize-space(.),'Sign in') or contains(normalize-space(.),'Log in') or contains(normalize-space(.),'Login') or @type='submit'])[1]");
    this.errorBanner = page.locator("xpath=(//*[@role='alert' or contains(@class,'error') or contains(@class,'alert') or contains(.,'invalid') or contains(.,'incorrect') or contains(.,'wrong')])[1]");
  }

  async open() {
    await this.page.goto('https://app.vwo.com/#/login');
    await this.emailInput.waitFor({ state: 'visible', timeout: 20000 });
  }

  async login(email: string, password: string, rememberMe: boolean = false) {
    await this.emailInput.fill(email);
    await this.passwordInput.fill(password);

    if (rememberMe) {
      await this.rememberMeCheckbox.check({ force: true }).catch(() => undefined);
    }

    await this.signInButton.click();
  }

  async expectErrorVisible() {
    await expect(this.errorBanner).toBeVisible({ timeout: 20000 });
  }

  async expectDashboardVisible() {
    await expect(this.page).toHaveURL(/app\.vwo|dashboard|workspace|home/i, { timeout: 30000 });
  }
}
