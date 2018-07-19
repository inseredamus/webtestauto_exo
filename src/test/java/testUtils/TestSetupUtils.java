package testUtils;

import enums.Url;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoadProperties;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestSetupUtils {

    protected WebDriver wd;
    private static Logger logger;
    protected Logger testLogger = Logger.getLogger(TestSetupUtils.class);
    protected String locationSymbolTest = "##### : ";
    private static String testInfo;
    private static int count = 0;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoadProperties loadApplication = new LoadProperties("application.properties");
    protected String urlToTest =  loadApplication.getPropValue("automation.practice.url");

    @Rule
    public TestName name = new TestName();

    @Rule
    public Timeout timeout = new Timeout(5, TimeUnit.MINUTES);


    @Rule
    public TestRule watchman = new TestWatcher() {
        public Statement apply(final Statement base, final Description description){
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    List<Throwable> errors = new ArrayList<>();
                    startingQuietly(description, errors);
                    try {
                        testInfo = description.toString();
                        base.evaluate();
                        succeededQuietly(description, errors);
                    } catch (NoSuchElementException e) {
                        System.out.println(e);
                    }catch (InterruptedException e) {
                        fail("Some Thread interrupted: "+ stackToString(e));
                    }catch (ArrayIndexOutOfBoundsException e) {
                        String element = e.toString().split("value=")[1].split("}")[0];
                        fail("Element \"" + element + "\" could not be located : ArrayIndexOutOfBoundsException \n");
                    }catch(IndexOutOfBoundsException e){
                        System.out.println(e);
                    }catch(NotFoundException nfe) {
                        fail("Not Found Exception: " + stackToString(nfe));
                    }catch(WebDriverException e){
                        fail("WebDriver Exception: " + stackToString(e));
                    }
                    MultipleFailureException.assertEmpty(errors);
                }
            };
        }

        private String stackToString(Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return "\n" + sw.toString() + "\n\n";
        }

        private void succeededQuietly(Description description, List<Throwable> errors) {
            try {
                succeeded(description);
            } catch (Throwable t) {
                errors.add(t);
            }
        }

        private void startingQuietly(Description description, List<Throwable> errors) {
            try {
                starting(description);
            } catch (Throwable t) {
                errors.add(t);
            }
        }

        protected void succeeded(Description description) {
        }

        protected void failed(Throwable e, Description description) {
        }

        protected void skipped(AssumptionViolatedException e, Description description) {
        }

        protected void starting(Description description) {
        }

        protected void finished(Description description) {
        }
    };


    @Before
    public void beforeEachTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10, 50);
        driver.get(Url.AUTOMATION_PRACTICE_TEST.getValue());

        PrintWriter writer = new PrintWriter("logs/logFile.log");
        writer.print("");
        writer.close();
        logger = Logger.getLogger(name.getMethodName());
        count++;

        if(count==1){
            writer = new PrintWriter("logs/finalLogFile.log");
            writer.print("");
            writer.close();
        }
        String temp = "=============== START : "+testInfo+" ========== test n°"+count+" ====";
        String mult = "";
        for (int i = 0; i < temp.length(); i++) {
            mult = mult+"=";
        }
        logger.info(mult);
        logger.info(temp);
        logger.info(mult);

        if (wd == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("chrome.switches","--disable-extensions");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            wd = new ChromeDriver();
            wd.manage().deleteAllCookies();
            Dimension d = new Dimension(363,700);
            wd.manage().window().setSize(d);
        }
        Web web = new Web(driver);
    }

    @After
    public void afterEachTest(){
        logger = Logger.getLogger(name.getMethodName());
        String temp = "=================== END : "+testInfo+" ===================";
        String mult = "";
        for (int i = 0; i < temp.length(); i++) {
            mult = mult+"=";
        }
        logger.info(mult);
        logger.info(temp);
        logger.info(mult);
        try {
            System.out.flush();
            wd.quit();
        } catch(NoSuchSessionException e) {
            fail("Not able to quit webdriverTests, crash?? : SessionNotFoundException " + e.toString());
        } catch(NullPointerException e){
            System.out.println("AfterClass : Not able to quit webdriver : " + e.toString());
        }
    }
}
