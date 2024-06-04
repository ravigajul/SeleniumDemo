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
Types
1. Absolute   
3. Relative
4. Parent-child
5. axes based

**Example XML for xpath selection**

```xml
<library>
    <section id="sec1">
        <book id="bk101">
            <author>Author 1</author>
            <title>XML Developer's Guide</title>
            <genre>Computer</genre>
            <price>44.95</price>
            <publish_date>2000-10-01</publish_date>
            <description>An in-depth look at creating applications with XML.</description>
        </book>
        <book id="bk102">
            <author>Author 2</author>
            <title>Midnight Rain</title>
            <genre>Fantasy</genre>
            <price>5.95</price>
            <publish_date>2000-12-16</publish_date>
            <description>A former architect battles corporate zombies, an evil sorceress, and her own childhood to become queen of the world.</description>
        </book>
    </section>
    <section id="sec2">
        <book id="bk103">
            <author>Author 3</author>
            <title>Maeve Ascendant</title>
            <genre>Fantasy</genre>
            <price>5.95</price>
            <publish_date>2000-11-17</publish_date>
            <description>After the collapse of a nanotechnology society in England, the young survivors lay the foundation for a new society.</description>
        </book>
    </section>
</library>
```

**Node Selection**
Root Node (/): Selects the root node of the document.
```xpath
/         # Selects the root node
.         # Selects the current node
//book    # Selects any node (all <book>) elements in the document
```

**Node Relationships**
```xpath
/library/book    # Selects all <book> elements that are direct children of <library>
/library/book/@id    # Selects the id attribute of all <book> elements
//book/..    # Selects the parent of each <book> element
```
**Predicates**: Used to find a specific node or a node that contains a specific value.
```xpath
//book[1]    # Selects the first <book> element
//book[@id='bk101']    # Selects the <book> element with id="bk101"
//book[contains(title, 'XML')]    # Selects all <book> elements with 'XML' in the title
```
**Functions**
```xpath
//book/title/text()    # Selects the text content of all <title> elements
//book[last()]    # Selects the last <book> element
//book[position()<3]    # Selects the first two <book> elements
```
**Axes**
XPath axes are used to define a node set relative to the current node. Below are all the examples of XPath axes with explanations and sample XML for context.

### Sample XML

```xml
<library>
    <section id="sec1">
        <book id="bk101">
            <author>Author 1</author>
            <title>XML Developer's Guide</title>
            <genre>Computer</genre>
            <price>44.95</price>
            <publish_date>2000-10-01</publish_date>
            <description>An in-depth look at creating applications with XML.</description>
        </book>
        <book id="bk102">
            <author>Author 2</author>
            <title>Midnight Rain</title>
            <genre>Fantasy</genre>
            <price>5.95</price>
            <publish_date>2000-12-16</publish_date>
            <description>A former architect battles corporate zombies, an evil sorceress, and her own childhood to become queen of the world.</description>
        </book>
    </section>
    <section id="sec2">
        <book id="bk103">
            <author>Author 3</author>
            <title>Maeve Ascendant</title>
            <genre>Fantasy</genre>
            <price>5.95</price>
            <publish_date>2000-11-17</publish_date>
            <description>After the collapse of a nanotechnology society in England, the young survivors lay the foundation for a new society.</description>
        </book>
    </section>
</library>
```

### Examples of All XPath Axes

| Axis                   | Description                                                | Example                                              | Result                        |
|------------------------|------------------------------------------------------------|------------------------------------------------------|-------------------------------|
| `ancestor::`           | Selects all ancestor nodes of the current node             | `//book/title/ancestor::section`                     | `<section id="sec1">...</section>` |
| `ancestor-or-self::`   | Selects all ancestors and the current node                 | `//book/title/ancestor-or-self::section`             | `<section id="sec1">...</section>` |
| `attribute::`          | Selects all attributes of the current node                 | `//book/attribute::id`                               | `bk101`, `bk102`, `bk103`     |
| `child::`              | Selects all child nodes of the current node                | `/library/child::section`                            | `<section id="sec1">...</section>` |
| `descendant::`         | Selects all descendants of the current node                | `/library/descendant::book`                          | `<book id="bk101">...</book>` |
| `descendant-or-self::` | Selects all descendants and the current node               | `/library/descendant-or-self::section`               | `<section id="sec1">...</section>` |
| `following::`          | Selects all nodes after the current node                   | `//book[@id='bk101']/following::book`                | `<book id="bk102">...</book>` |
| `following-sibling::`  | Selects all siblings after the current node                | `//book[@id='bk101']/following-sibling::book`        | `<book id="bk102">...</book>` |
| `namespace::`          | Selects all namespace nodes of the current node            | `//book/namespace::*`                                | *No output (no namespaces)*  |
| `parent::`             | Selects the parent of the current node                     | `//title/parent::book`                               | `<book id="bk101">...</book>` |
| `preceding::`          | Selects all nodes before the current node in the document  | `//book[@id='bk103']/preceding::book`                | `<book id="bk101">...</book>` |
| `preceding-sibling::`  | Selects all siblings before the current node               | `//book[@id='bk102']/preceding-sibling::book`        | `<book id="bk101">...</book>` |
| `self::`               | Selects the current node                                   | `//book[@id='bk101']/self::book`                     | `<book id="bk101">...</book>` |


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
