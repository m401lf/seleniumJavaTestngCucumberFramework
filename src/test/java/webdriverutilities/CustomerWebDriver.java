package webdriverutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class CustomerWebDriver {
	private static CustomerWebDriver instance = null;
	private WebDriver webDriver;

	private CustomerWebDriver() {
	}

	public WebDriver openBrowser(String url, DesiredCapabilities caps) throws MalformedURLException {
		webDriver = WebDriverConfig
				.configureAndOpenBrowser(url, caps,
						webDriver);
		return webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;

	}

	public static CustomerWebDriver getInstance() {
		if (instance == null) {
			instance = new CustomerWebDriver();
		}
		return instance;
	}

}
