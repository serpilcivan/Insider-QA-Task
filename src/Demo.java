import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Demo {
    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\QUADRO\\Desktop\\Selenium\\Installers\\drivers\\chromedriver.exe");
        System.out.print("Opening Chrome...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts();
        //open web page
        driver.get("https://useinsider.com/");
        System.out.println("● Opened https://useinsider.com/");

    }

    //check with the title of the page. If you get title of the page, it means page is opened.
    public void checkHomePage() {
        String expectedTitle = "Insider";

        if (driver.getTitle() != null && driver.getTitle().contains(expectedTitle)) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page could not open.");
        }


    }

    //go careers page
    public void careers() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.linkText("More")).click();
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Careers")).click();
    }

    //check Career page, its Culture, Locations, Teams,
    //Jobs and Life at Insider blocks
    public void element() throws InterruptedException {


        String pagesource = driver.getPageSource();
        String t = "Culture";
        if (pagesource.contains(t)) {

            System.out.println(t + " is present.");
        } else {

            System.out.println(t + " is not present.");
        }


        String t1 = "Location";
        if (pagesource.contains(t1)) {

            System.out.println(t1 + " is present.");
        } else {

            System.out.println(t1 + " is not present.");
        }
        String t2 = "Team";
        if (pagesource.contains(t1)) {

            System.out.println(t2 + " is present.");
        } else {

            System.out.println(t2 + " is not present.");
        }
        String t3 = "Job";
        if (pagesource.contains(t1)) {

            System.out.println(t3 + " is present.");
        } else {

            System.out.println(t3 + " is not present.");
        }
        String t4 = "Life at Insider";
        if (pagesource.contains(t1)) {

            System.out.println(t4 + " is present.");
        } else {

            System.out.println(t4 + " is not present.");
        }

    }
    //Scroll to Career Opportunities

    public void careerPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.xpath("//section[@id='find-job-widget']"));

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);

        driver.findElement(By.xpath("//a[contains(@href, 'https://useinsider.com/open-positions/')]")).click();

    }

    //filter jobs by Location - Istanbul, Turkey
    public void locationList() throws InterruptedException {
        //a[@class='btn btn-info rounded mr-0 mr-md-4 py-sm-3 py-2']


        List<WebElement> items = driver.findElements(By.xpath("//ul[@id='select2-filter-by-location-results']"));
        Thread.sleep(3000);


        WebElement location = driver.findElement(By.id("select2-filter-by-location-container"));
        location.click();   // to open the "pull down"
        Thread.sleep(3000);


        List<WebElement> city = driver.findElements(By.xpath("//ul[@id='select2-filter-by-location-results']"));
        for (WebElement option : city) {
            System.out.println(option.getText());
            if (option.getText().contains("Istanbul")) {


                driver.findElement(By.xpath("//ul[contains(@class, 'select2-results__options')]/li[15]")).click();
                break;
            }
        }
    }

    //filter jobs by department -Quality Assurance
    public void departmentList() throws InterruptedException {
        //a[@class='btn btn-info rounded mr-0 mr-md-4 py-sm-3 py-2']


        List<WebElement> items = driver.findElements(By.xpath("//ul[@id='select2-filter-by-location-results']"));
        Thread.sleep(3000);


        WebElement department = driver.findElement(By.id("select2-filter-by-department-container"));
        department.click();   // to open the "pull down"
        Thread.sleep(3000);


        List<WebElement> options = driver.findElements(By.xpath("//ul[@id='select2-filter-by-department-results']"));
        for (WebElement option : options) {
            System.out.println(option.getText());
            if (option.getText().contains("Quality")) {


                driver.findElement(By.xpath("//ul[contains(@class, 'select2-results__options')]/li[13]")).click();
                break;
            }
        }
    }

    //check jobs list
    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Find element by link text and store in variable "Element1"
        WebElement Element1 = driver.findElement(By.xpath("//section[@id='career-position-list']"));

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element1);
    }
//Select one of the positions

    public void apply() {

        WebElement mainMenu = driver.findElement(By.linkText("Software Quality Assurance Analyst"));

        Actions actions = new Actions(driver);

        actions.moveToElement(mainMenu);

        WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Apply Now')])[3]"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

    }

    // check that correct position page is opened
    public void checkPosition() {

        driver.get("https://jobs.lever.co/useinsider/0e39c3f1-0dde-455f-8b15-3f68bbce5a0e");
        String expectedTitle = "Software Quality Assurance Analyst";
        String url = "https://jobs.lever.co/useinsider/0e39c3f1-0dde-455f-8b15-3f68bbce5a0e";
        driver.get(url);
        if (driver.getTitle() != null && driver.getTitle().contains(expectedTitle)) {
            System.out.println("Correct web page is opened");
        } else {
            System.out.println("Correct web page could not open.");
        }
    }

    //check with description, requirements and “Apply for this job” button
    public void verifyPage() throws Exception {
        driver.get("https://jobs.lever.co/useinsider/0e39c3f1-0dde-455f-8b15-3f68bbce5a0e");

        String pagesource = driver.getPageSource();

        if (pagesource.contains("A Software Quality Assurance Analyst in Insider day in and day out:")) {

            System.out.println("search done correctly from page source");
        } else {

            System.out.println("wrong page");
        }

        //control apply button


        boolean actualValue = driver.findElement(By.xpath("//a[contains(text(),'Apply for this job')]")).isDisplayed();

        if (actualValue = true)
            System.out.println("Button is displayed");
        else
            System.out.println("Button is not display");


    }

    //Click “Apply for this job” button and check that this action redirects us to Lever Application page

    public void applyJob() throws Exception {

        driver.findElement(By.xpath("//a[contains(text(),'Apply for this job')]")).click();

        //check redirect page
        String expectedUrl = "https://jobs.lever.co/useinsider/6013cc18-8219-4587-a78c-9325c137b436/apply";

        if (driver.getCurrentUrl() != null && driver.getCurrentUrl().contains(expectedUrl)) {
            System.out.println("Correct web page is opened");
        } else {
            System.out.println("Correct web page could not open.");
        }

    }

    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        demo.launchBrowser();
        demo.checkHomePage();
        demo.careers();
        demo.element();
        demo.careerPage();
        demo.locationList();
        demo.departmentList();
        demo.scroll();
        //demo.apply();
        demo.checkPosition();
        demo.verifyPage();
        demo.applyJob();
    }
}


