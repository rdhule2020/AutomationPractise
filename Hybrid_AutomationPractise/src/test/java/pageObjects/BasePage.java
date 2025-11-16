package pageObjects;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{
	
	WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		
	}
	
	
	 /**
     * Uploads a file using the Robot class by simulating keyboard input.
     *
     * @param filePath Full path to the file to upload.
     * @throws AWTException if the platform configuration does not allow low-level input control.
     * @throws InterruptedException if thread is interrupted during sleep.
     */
    public static void uploadFileWithRobot(String filePath) throws AWTException, InterruptedException {
        // Copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Create Robot instance
        Robot robot = new Robot();
        robot.setAutoDelay(100);

        // Wait a little for dialog to appear
        Thread.sleep(5000);

        // Paste the file path (CTRL + V)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    
}
    
    
    
}
