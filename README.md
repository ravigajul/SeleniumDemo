# SeleniumDemo

## Principles for Effective Automation Testing

Ensuring Readability, Maintainability, and Scalability

The goal of automation testing is to create test scripts that are readable, maintainable, and scalable, ensuring that tests can be easily understood, modified, and expanded as the application evolves. This enhances the efficiency of the testing process and helps maintain high software quality over time.

## BadPractises

1. Duplicate locators & code
2. Non Readable tests. Tests having technial information. Having the how instead of what. The how should be in the page object classes.
3. Duplicate driver initializations.
4. Having Thread.sleep
5. Hardcoded test data
6. Hardcoded static text in assertions or elsewhere
7. Lack of multibrowser support
8. Stale browser instances, not quitting in case of failures or aborts

## Automation Design Principles

In the context of automation testing, adhering to software design principles like DRY (Don't Repeat Yourself), SRP (Single Responsibility Principle), and OOP (Object-Oriented Programming) can greatly improve the maintainability, readability, and efficiency of your test code. Here's an overview of each principle:

### DRY (Don't Repeat Yourself)

DRY aims to reduce redundancy by abstracting repeated code into reusable functions or modules. This minimizes maintenance efforts and enhances code readability.
Example:
```java
// DRY Principle Example
public class LoginUtil {

    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }
}

public class UserTests {

    public void testUserLogin() {
        WebDriver driver = new ChromeDriver();
        LoginUtil.login(driver, "user1", "password1");
        assert driver.findElement(By.id("welcomeMessage")).isDisplayed();
        driver.quit();
    }

    public void testAdminLogin() {
        WebDriver driver = new ChromeDriver();
        LoginUtil.login(driver, "admin", "adminpassword");
        assert driver.findElement(By.id("adminDashboard")).isDisplayed();
        driver.quit();
    }
}
```

### SRP (Single Responsibility Principle)

SRP states that a class or module should have only one reason to change, meaning it should focus on a single functionality. This promotes modularity and simplifies code maintenance.
Example:

```java
// SRP Principle Example
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }
}

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeMessageDisplayed() {
        return driver.findElement(By.id("welcomeMessage")).isDisplayed();
    }
}

public class UserTests {

    public void testUserLogin() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        
        loginPage.login("user1", "password1");
        assert dashboardPage.isWelcomeMessageDisplayed();
        driver.quit();
    }
}
```

### OOP (Object-Oriented Programming)

OOP organizes code into objects containing data and methods, using principles like encapsulation, inheritance, polymorphism, and abstraction. This improves code reusability, scalability, and ease of understanding.
Example:
```java
// OOP Principles Example
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        sendKeys(By.id("username"), username);
        sendKeys(By.id("password"), password);
        click(By.id("loginButton"));
    }
}

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWelcomeMessageDisplayed() {
        return driver.findElement(By.id("welcomeMessage")).isDisplayed();
    }
}

public class UserTests {

    public void testUserLogin() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        
        loginPage.login("user1", "password1");
        assert dashboardPage.isWelcomeMessageDisplayed();
        driver.quit();
    }
}
```

## Designing Page Object Model using Selenium Java

### Create Individual Page Classes

Create a separate class for each page you interact with to encapsulate all interactions and locators for that page.

### Locators Strategy

Use a robust locator strategy (e.g., By.id, By.name, By.xpath, By.cssSelector, etc) to ensure elements are accurately identified.

### Navigation Methods

Ensure that methods responsible for navigation return the new page object you are navigating to, facilitating smooth transitions between pages.

```java
public class LoginPage {
     public DashboardPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new DashboardPage(driver);
    }
}
```

### Builder Pattern for Method Chaining

Implement the builder pattern to chain methods within the same page, improving readability and fluidity of page interactions.

```java
ConfirmationPage confirmationPage = checkOutPage.
        enterFirstName("John").
        enterLastName("Doe").
        selectCountry().
        enterAddress("13230").
        enterCity("Monroe").
        enterZip("98272").
        enterPhone("1234567890").
        enterEmail("ravi@test.com").
        enterZip("98272").
        clickPlaceOrderButton();
```

### Structural vs. Functional Pattern

Choose between structural pattern (one method per action) or functional pattern (grouping multiple actions into one method) based on the specific needs of your tests.

### Dynamic UI Elements

Handle dynamic UI elements efficiently to ensure your tests are robust and adaptable to changes in the UI.

### Lightweight Data Objects

Use lightweight data objects like JSON files for managing test data, separating data from test logic for better maintainability.

### Descriptive Function Names

Name functions to clearly represent the actions being performed rather than the implementation details, enhancing the readability of your test code.

### Error Handling and Logging

Implement error handling and logging within page methods to capture failures and improve debugging capabilities.

### Synchronization

Use appropriate waits (explicit, implicit) to handle dynamic content and ensure elements are ready for interaction.
 https://www.selenium.dev/documentation/webdriver/waits/  

## Maven Goal to execute All Tests

```bash
mvn clean test 
//to run on msedge, assuming browser is the system property configured in the code
mvn clean test -Dbrowser="msedge"

```