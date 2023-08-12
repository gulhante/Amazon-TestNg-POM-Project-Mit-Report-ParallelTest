package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTestReport {


    protected static Actions actions;

    protected static ExtentReports extentReports; // raporlama islemini gerceklestirir

    protected static ExtentSparkReporter extentHtmlReporter; // raporu HTML olarak duzenler

    protected static ExtentTest extentTest; // testimizin pass veya fail oldugunu saklayan objemiz. Ekran goruntuleri icin de kullanilir

    @BeforeClass
    public void setup(){

        actions = new Actions(Driver.getDriver());

        //Extent report objelerimizi de olusturuyoruz
        extentReports = new ExtentReports();

        // Kaydedecegimiz dosya icin tarih stringi olusturuldu
        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/reports/testReport_" + currentDate + ".html";

        // HTML raporu olusturacak obje dosya yoluyla initialize edildi
        extentHtmlReporter = new ExtentSparkReporter(filePath);

        // Raporlama yapan extentreport objemize HTML reporter baglandi
        extentReports.attachReporter(extentHtmlReporter);

        // Rapor ile alakali ekstra opsiyonel bilgiler verildi
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Gülhan Tezcan");

        // HTML raporunda goruntulemek istedigimiz konfigurasyonlar yapildi
        extentHtmlReporter.config().setDocumentTitle("CWReport");
        extentHtmlReporter.config().setReportName("Test run report");


    }

//    @AfterMethod
//    public void teardown(){
//
//        //driver.quit();
//
//    }

    @AfterMethod
    public static void afterClass(){
        extentReports.flush();
    }
}
