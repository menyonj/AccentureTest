package steps;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccentureTest {
	private WebDriver driver;

	@Given("Que eu esteja na pagina da Tricents")
	public void que_eu_esteja_na_pagina_da_tricents() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://sampleapp.tricentis.com/101/app.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("nav_automobile")).click();
	}

	@When("Preencher o formulario, aba Enter Vehicle Data e pressione next")
	public void na_aba_enter_vehicle_data() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String esperado = "Enter Vehicle Data";
		assertEquals(esperado, driver.getTitle());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("make")));
		driver.findElement(By.id("make")).click();
		{
			WebElement dropdown = driver.findElement(By.id("make"));
			dropdown.findElement(By.xpath("//option[. = 'Audi']")).click();
		}
		driver.findElement(By.id("engineperformance")).sendKeys("600");
		driver.findElement(By.id("opendateofmanufacturecalender")).click();
		driver.findElement(By.cssSelector(".ui-datepicker-prev")).click();
		driver.findElement(By.linkText("1")).click();
		driver.findElement(By.id("numberofseats")).sendKeys("4");
		driver.findElement(By.id("fuel")).click();
		{
			WebElement dropdown = driver.findElement(By.id("fuel"));
			dropdown.findElement(By.xpath("//option[. = 'Gas']")).click();
		}
		driver.findElement(By.id("listprice")).sendKeys("50000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("123456abc");
		driver.findElement(By.id("annualmileage")).sendKeys("10000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
	}

	@And("Preencher o formulario, aba Enter Product Data e pressione next")
	public void na_aba_enter_product_data() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String esperado = "Enter Product Data";
		assertEquals(esperado, driver.getTitle());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("startdate")));
		driver.findElement(By.id("startdate")).sendKeys("09/20/2022");
		driver.findElement(By.id("insurancesum")).sendKeys("35.000.000,00");
		driver.findElement(By.id("meritrating")).click();
		{
			WebElement dropdown = driver.findElement(By.id("meritrating"));
			dropdown.findElement(By.xpath("//option[. = 'Malus 10']")).click();
		}
		driver.findElement(By.id("damageinsurance")).click();
		{
			WebElement dropdown = driver.findElement(By.id("damageinsurance"));
			dropdown.findElement(By.xpath("//option[. = 'Full Coverage']")).click();
		}
		driver.findElement(By.cssSelector(".field:nth-child(5) .ideal-radiocheck-label:nth-child(1) > .ideal-check"))
				.click();
		driver.findElement(By.cssSelector(".field:nth-child(5) .ideal-radiocheck-label:nth-child(2) > .ideal-check"))
				.click();
		driver.findElement(By.id("courtesycar")).sendKeys("Yes");
		driver.findElement(By.id("nextselectpriceoption")).click();
	}

	@And("Preencher o formulario, aba Select Price Option e pressione next")
	public void na_aba_select_price_option() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String esperado = "Select Price Option";
		assertEquals(esperado, driver.getTitle());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("selectultimate")));
		driver.findElement(By.xpath("//table[@id='priceTable']/tfoot/tr/th[2]/label[4]/span")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nextsendquote")));
		driver.findElement(By.id("nextsendquote")).click();
	}

	@When("Preencher o formulario, aba Send Quote e pressione Send")
	public void na_aba_send_quote() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String esperado = "Send Quote";
		assertEquals(esperado, driver.getTitle());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).sendKeys("jsmenyon@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("5511986767733");
		driver.findElement(By.id("username")).sendKeys("menyonj");
		driver.findElement(By.id("password")).sendKeys("Meny2526");
		driver.findElement(By.id("confirmpassword")).sendKeys("Meny2526");
		driver.findElement(By.id("Comments")).sendKeys("jsmenyon@gmail.com");
		driver.findElement(By.id("sendemail")).click();
	}

	@And("Preencher o formulario, aba Enter Insurant Data e pressione next")
	public void na_aba_enter_insurant_data() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String esperado = "Enter Insurant Data";
		assertEquals(esperado, driver.getTitle());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
		driver.findElement(By.id("firstname")).sendKeys("Jessica");
		driver.findElement(By.id("lastname")).sendKeys("Menyon");
		driver.findElement(By.id("birthdate")).sendKeys("06/09/1997");
		driver.findElement(By.cssSelector(".group:nth-child(2) > .ideal-radiocheck-label:nth-child(1) > .ideal-radio"))
				.click();
		driver.findElement(By.id("streetaddress")).sendKeys("Av. Nações Unidas, 574");
		driver.findElement(By.cssSelector(".idealsteps-step:nth-child(2)")).click();
		driver.findElement(By.id("country")).click();
		{
			WebElement dropdown = driver.findElement(By.id("country"));
			dropdown.findElement(By.xpath("//option[. = 'Brazil']")).click();
		}
		driver.findElement(By.id("zipcode")).sendKeys("04578911");
		driver.findElement(By.cssSelector(".idealsteps-step:nth-child(2)")).click();
		driver.findElement(By.id("city")).sendKeys("São Paulo");
		driver.findElement(By.id("occupation")).click();
		{
			WebElement dropdown = driver.findElement(By.id("occupation"));
			dropdown.findElement(By.xpath("//option[. = 'Employee']")).click();
		}
		driver.findElement(By.cssSelector(".field:nth-child(10) .ideal-radiocheck-label:nth-child(1) > .ideal-check"))
				.click();
		driver.findElement(By.cssSelector(".ideal-radiocheck-label:nth-child(4) > .ideal-check")).click();
		driver.findElement(By.id("picturecontainer"))
				.sendKeys(System.getProperty("user.dir") + File.separator + "imgs" + File.separator + "yoda.jpg");
		driver.findElement(By.id("website")).sendKeys("www.google.com.br");
		driver.findElement(By.id("nextenterproductdata")).click();
	}

	@Then("validar a mensagem de envio com sucesso")
	public void validar_a_mensagem_de_envio_com_sucesso() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/h2")));
		String esperado = "Sending e-mail success!";
		try {
			assertEquals(esperado, driver.findElement(By.xpath("/html/body/div[4]/h2")).getText());
			driver.quit();
		} catch (Exception e) {
			throw new Error("Cadastro não efetuado com sucesso!");
		}
	}

}
