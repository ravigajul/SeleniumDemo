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

### Xpath
Tabular summary of XPath selectors:

| **Selector Type**              | **Pattern**                              | **Description**                                                     | **Example**                              |
|--------------------------------|------------------------------------------|---------------------------------------------------------------------|------------------------------------------|
| **Root Node**                  | `/`                                      | Selects the root node                                               | `/`                                      |
| **Current Node**               | `.`                                      | Selects the current node                                            | `.`                                      |
| **Parent Node**                | `..`                                     | Selects the parent of the current node                               | `..`                                     |
| **Element Node**               | `//element`                              | Selects all nodes with the specified element name                    | `//div`                                  |
| **Any Element**                | `//*`                                    | Selects all elements                                                | `//*`                                    |
| **Attribute**                  | `@attribute`                             | Selects elements with the specified attribute                        | `//@class`                               |
| **Specific Attribute**         | `//element[@attribute='value']`          | Selects elements with a specific attribute value                     | `//input[@type='text']`                  |
| **Child Nodes**                | `element/child`                          | Selects all children of the specified element                        | `div/p`                                  |
| **Descendant Nodes**           | `element//descendant`                    | Selects all descendants of the specified element                     | `div//span`                              |
| **Wildcard Node**              | `*`                                      | Matches any node                                                    | `//*`                                    |
| **Text Node**                  | `text()`                                 | Selects the text node of the current element                         | `//p/text()`                             |
| **Contains Function**          | `contains(node, 'text')`                 | Selects nodes containing the specified text                          | `//p[contains(text(), 'example')]`       |
| **Starts-with Function**       | `starts-with(node, 'text')`              | Selects nodes where the text starts with the specified value         | `//p[starts-with(text(), 'example')]`    |
| **Position Function**          | `position()`                             | Selects nodes based on their position                                | `//li[position()=1]`                     |
| **Last Function**              | `last()`                                 | Selects the last node                                                | `//li[last()]`                           |
| **Node Attribute Value**       | `//element[@attribute]`                  | Selects elements with the specified attribute                        | `//a[@href]`                             |
| **Parent Axis**                | `parent::`                               | Selects the parent of the current node                               | `//title/parent::book`                   |
| **Ancestor Axis**              | `ancestor::`                             | Selects all ancestors of the current node                            | `//title/ancestor::book`                 |
| **Ancestor-or-self Axis**      | `ancestor-or-self::`                     | Selects the current node and all its ancestors                       | `//title/ancestor-or-self::book`         |
| **Attribute Axis**             | `attribute::`                            | Selects all attributes of the current node                           | `//book/attribute::*`                    |
| **Child Axis**                 | `child::`                                | Selects all children of the current node                             | `//book/child::title`                    |
| **Descendant Axis**            | `descendant::`                           | Selects all descendants of the current node                          | `//book/descendant::title`               |
| **Descendant-or-self Axis**    | `descendant-or-self::`                   | Selects the current node and all its descendants                     | `//book/descendant-or-self::title`       |
| **Following Axis**             | `following::`                            | Selects everything in the document after the closing tag of the current node | `//book/following::title`          |
| **Following-sibling Axis**     | `following-sibling::`                    | Selects all siblings after the current node                          | `//book/following-sibling::title`        |
| **Namespace Axis**             | `namespace::`                            | Selects all namespace nodes of the current node                      | `//book/namespace::*`                    |
| **Parent Axis**                | `parent::`                               | Selects the parent of the current node                               | `//title/parent::book`                   |
| **Preceding Axis**             | `preceding::`                            | Selects all nodes that appear before the current node                | `//title/preceding::book`                |
| **Preceding-sibling Axis**     | `preceding-sibling::`                    | Selects all siblings before the current node                         | `//title/preceding-sibling::book`        |
| **Self Axis**                  | `self::`                                 | Selects the current node                                             | `//title/self::book`                     |
| **And Condition**              | `node1[condition1 and condition2]`       | Selects nodes that match both conditions                             | `//input[@type='text' and @name='user']` |
| **Or Condition**               | `node1[condition1 or condition2]`        | Selects nodes that match either condition                            | `//input[@type='text' or @name='user']`  |
| **Union Operator**             | `path1 | path2`                          | Selects nodes from either path                                       | `//h1 | //h2`                             |
| **Multiple Attribute Conditions** | `node[@attr1 and @attr2]`              | Selects nodes that match multiple attribute conditions               | `//input[@type and @name]`               |
| **Substring Function**         | `substring(node, start, length)`         | Selects a substring of the text of the node                          | `substring(//title, 1, 3)`               |
| **String Length Function**     | `string-length(node)`                    | Returns the length of the text of the node                           | `string-length(//title)`                 |
| **Normalize Space Function**   | `normalize-space(node)`                  | Strips leading and trailing whitespace and reduces whitespace inside | `normalize-space(//title)`               |

This table includes all major XPath selectors and provides a comprehensive reference for various types and patterns of XPath expressions.

### CSS Selectors summary
This table includes all major CSS selectors, providing a comprehensive reference for various types and patterns of CSS selectors.

| **Selector Type**           | **Pattern**                | **Description**                                                   | **Example**                     |
|-----------------------------|----------------------------|-------------------------------------------------------------------|---------------------------------|
| **Universal Selector**      | `*`                        | Selects all elements                                              | `*`                             |
| **Type Selector**           | `element`                  | Selects all elements of the specified type                        | `p`                             |
| **Class Selector**          | `.classname`               | Selects all elements with the specified class                     | `.intro`                        |
| **ID Selector**             | `#id`                      | Selects the element with the specified ID                         | `#header`                       |
| **Attribute Selector**      | `[attribute]`              | Selects elements with the specified attribute                     | `[type]`                        |
| **Attribute Value**         | `[attribute=value]`        | Selects elements with the specified attribute value               | `[type='text']`                 |
| **Child Selector**          | `parent > child`           | Selects direct child elements of a specified parent               | `div > p`                       |
| **Descendant Selector**     | `ancestor descendant`      | Selects all descendants of a specified ancestor                   | `div p`                         |
| **Adjacent Sibling**        | `prev + next`              | Selects the next sibling element                                  | `h1 + p`                        |
| **General Sibling**         | `prev ~ siblings`          | Selects all sibling elements                                      | `h1 ~ p`                        |
| **Pseudo-class**            | `:pseudo-class`            | Selects elements based on their state or position                 | `a:hover`                       |
| **Pseudo-element**          | `::pseudo-element`         | Selects and styles a part of an element                           | `p::first-line`                 |
| **Group Selector**          | `selector1, selector2`     | Selects all elements matching any of the grouped selectors        | `h1, h2, h3`                    |
| **Nth-child Selector**      | `:nth-child(n)`            | Selects the nth child of a parent element                         | `li:nth-child(2)`               |
| **Nth-last-child**          | `:nth-last-child(n)`       | Selects the nth child from the end                                | `li:nth-last-child(1)`          |
| **First-child**             | `:first-child`             | Selects the first child of a parent element                       | `p:first-child`                 |
| **Last-child**              | `:last-child`              | Selects the last child of a parent element                        | `p:last-child`                  |
| **Only-child**              | `:only-child`              | Selects elements that are the only child of their parent          | `p:only-child`                  |
| **First-of-type**           | `:first-of-type`           | Selects the first element of its type within its parent           | `p:first-of-type`               |
| **Last-of-type**            | `:last-of-type`            | Selects the last element of its type within its parent            | `p:last-of-type`                |
| **Nth-of-type**             | `:nth-of-type(n)`          | Selects the nth element of its type within its parent             | `p:nth-of-type(2)`              |
| **Nth-last-of-type**        | `:nth-last-of-type(n)`     | Selects the nth element of its type from the end                  | `p:nth-last-of-type(1)`         |
| **Empty Selector**          | `:empty`                   | Selects elements that have no children                            | `div:empty`                     |
| **Not Selector**            | `:not(selector)`           | Selects elements that do not match the selector                   | `:not(.exclude)`                |
| **Enabled Selector**        | `:enabled`                 | Selects enabled form elements                                     | `input:enabled`                 |
| **Disabled Selector**       | `:disabled`                | Selects disabled form elements                                    | `input:disabled`                |
| **Checked Selector**        | `:checked`                 | Selects checked form elements                                     | `input:checked`                 |
| **Lang Selector**           | `:lang(language)`          | Selects elements with a specific language attribute               | `:lang(en)`                     |
| **Root Selector**           | `:root`                    | Selects the document's root element                               | `:root`                         |
| **Focus Selector**          | `:focus`                   | Selects the element that has focus                                | `input:focus`                   |
| **Target Selector**         | `:target`                  | Selects the current active target element                         | `#section1:target`              |
| **Hover Selector**          | `:hover`                   | Selects elements when the mouse is over them                      | `a:hover`                       |
| **Active Selector**         | `:active`                  | Selects and styles the active link                                | `a:active`                      |
| **Visited Selector**        | `:visited`                 | Selects links that have been visited                              | `a:visited`                     |
| **Before Pseudo-element**   | `::before`                 | Inserts content before the content of the element                 | `p::before`                     |
| **After Pseudo-element**    | `::after`                  | Inserts content after the content of the element                  | `p::after`                      |
| **First-letter Pseudo-element** | `::first-letter`       | Selects the first letter of the element                           | `p::first-letter`               |
| **First-line Pseudo-element** | `::first-line`           | Selects the first line of the element                             | `p::first-line`                 |
| **Placeholder Selector**    | `::placeholder`            | Selects the placeholder text in an input element                  | `input::placeholder`            |
| **Selection Selector**      | `::selection`              | Selects the portion of an element that is selected by a user      | `::selection`                   |
| **Focus-within Selector**   | `:focus-within`            | Selects an element if any of its descendants have focus           | `div:focus-within`              |
| **Read-only Selector**      | `:read-only`               | Selects elements that are read-only                               | `input:read-only`               |
| **Read-write Selector**     | `:read-write`              | Selects elements that are read-write                              | `input:read-write`              |
| **In-range Selector**       | `:in-range`                | Selects elements with a value within a specified range            | `input:in-range`                |
| **Out-of-range Selector**   | `:out-of-range`            | Selects elements with a value outside a specified range           | `input:out-of-range`            |
| **Valid Selector**          | `:valid`                   | Selects form elements with a valid value                          | `input:valid`                   |
| **Invalid Selector**        | `:invalid`                 | Selects form elements with an invalid value                       | `input:invalid`                 |
| **Required Selector**       | `:required`                | Selects required form elements                                    | `input:required`                |
| **Optional Selector**       | `:optional`                | Selects optional form elements                                    | `input:optional`                |
| **Fullscreen Selector**     | `:fullscreen`              | Selects the element that is in fullscreen mode                    | `:fullscreen`                   |


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
## Usinf CDP in C#
using using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.DevTools;
using OpenQA.Selenium.DevTools.V139; // Use v139 matching your Chrome version

public class BrowserAuthHelper
{
    public static async Task<IWebDriver> CreateChromeWithBasicAuthAsync(string username, string password)
    {
        var options = new ChromeOptions();
        // Add your specific options if needed

        var driver = new ChromeDriver(options);
        var devTools = driver.GetDevToolsSession();
        var domains = devTools.GetVersionSpecificDomains<V139.DevToolsSessionDomains>();

        // Enable network domain in DevTools
        await domains.Network.Enable(new Network.EnableCommandSettings());

        // Send Basic Auth credentials
        await domains.Network.Authenticate(new Network.AuthenticateCommandSettings
        {
            Username = username,
            Password = password
        });

        return driver;
    }
}