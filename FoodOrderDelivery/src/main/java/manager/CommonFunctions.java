package manager;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

public class CommonFunctions {

	WebDriver driver;
	public static final String currentDateTime = dateTimeGenerate();

	public void NavigateToWindow(String windowTitle) {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if (driver.getTitle().contains(windowTitle)) {
				break;
			} else {
				driver.switchTo().window(winHandle);
			}
		}
	}

	public static final String dateTimeGenerate() {
		Format formatter = new SimpleDateFormat("YYYYMMdd_HHmmssSSS");
		Date date = new Date(System.currentTimeMillis());
		String filePath = formatter.format(date);
		return filePath;
	}

	public void takeSnapShot(WebDriver driver) throws IOException {
		String fileName = "ss_" + LocalDateTime.now().toString() + ".png";
		fileName = fileName.replace(':', '_');
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String fileWithPath1 = "C://ScreenShot/" + currentDateTime + "/" + fileName;
		File DestFile = new File(fileWithPath1);
		FileUtils.copyFile(SrcFile, DestFile);
		Reporter.addScreenCaptureFromPath("C://ScreenShot/" + currentDateTime + "/" + fileName);

	}

}
