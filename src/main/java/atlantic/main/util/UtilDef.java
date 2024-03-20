package atlantic.main.util;

import java.time.Duration;
import java.util.Properties;

import net.serenitybdd.core.Serenity;

//import net.thucydides.core.environment.SystemEnvironmentVariables;
//import net.thucydides.core.util.SystemEnvironmentVariables;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import net.thucydides.core.util.EnvironmentVariables;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilDef extends PageObject{

	Random random = new Random();

	public static Properties p;
	private static UtilDef obj = null;

	public static UtilDef getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new UtilDef();
		}
	}


	public void esperarElemento(int intentos, WebElement elemento) {
		int contador=0;
		System.out.println("Espera Elemento : "  + elemento.toString());
		Serenity.takeScreenshot();
		while(element(elemento).isEnabled()==false) {
			contador++;
			if(element(elemento).isEnabled()==true||contador==intentos) {
				System.out.println("Se encuentra elemento o contador finalizo");
				break;
			}else {
				esperarSegundos(1);
				System.out.println("contador: " + contador + elemento);
			}

		}
	}


	public void esperarSegundos(int tipoEspera) {

		try {
			Thread.sleep(tipoEspera*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String obtnerMensaje(WebElement webelement, int intentos) {
		boolean flag = false;
		String mensajeConfirmacion="";
		flag = confirmarElementoActivo(3, webelement);
		System.out.println("flag "  + flag);
		if(flag==true) {
			mensajeConfirmacion = webelement.getText();
		}else {
			mensajeConfirmacion="No se recibio mensaje";
		}
		return mensajeConfirmacion;
	}

	public boolean confirmarElementoActivo(int intentos, WebElement elemento) {
		int contador=0;
		System.out.println("Espera Elemento : "  + elemento.toString());
		Serenity.takeScreenshot();
		boolean confirmacion = true;
		while(element(elemento).isEnabled()==false) {
			confirmacion = false;
			contador++;
			if(element(elemento).isEnabled()==true) {
				System.out.println("Se encuentra elemento");
				confirmacion = true;
				break;
			}
			if(element(elemento).isEnabled()==true||contador==intentos) {
				System.out.println("Se encuentra elemento o contador finalizo");
				break;
			}else {
				esperarSegundos(1);
				System.out.println("contador: " + contador + elemento);
			}
		}
		return confirmacion;
	}

	/**
	 * Metodo espera a que elemento sea visibile en el dom, segun su xpath.
	 *
	 * @param driver
	 * @param tiempo_seg
	 * @param xpath
	 */
	public void esperar_visibilidad_elemento(WebDriver driver, int tiempo_seg, final String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(tiempo_seg));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void navegarDentroIframe(String xpath){
		withAction().moveToElement(find(By.xpath(xpath))).perform();
		WebElement iframe = getDriver().findElement(By.xpath(xpath));
		getDriver().switchTo().frame(iframe);
	}

	public void navegarDentroPopUp(String xpath){
		withAction().moveToElement(find(By.xpath(xpath))).perform();
		WebElement popUp = getDriver().findElement(By.xpath(xpath));
		getDriver().switchTo().frame(popUp);
	}

	public String concatenarSimboloMoneda(String dato, String moneda){
		String valorConcatenado="";
		if (moneda=="PEN"){
			valorConcatenado="S/ "+dato;
			System.out.println("ValorConcatenado:"+valorConcatenado);
		}else {
			valorConcatenado="USD "+dato;
		}
		return valorConcatenado;
	}

	public String extraerValor(String texto) {
		Pattern pattern = Pattern.compile("\\d+\\.\\d{2}");
		Matcher matcher = pattern.matcher(texto);
		if (matcher.find()) {
			return matcher.group(0);
		} else {
			return null;
		}
	}

	public String convertirFormatoPagoQR(String texto) {
		Pattern pattern = Pattern.compile("S/(\\d+)");
		Matcher matcher = pattern.matcher(texto);
		if (matcher.find()) {
			String numero = matcher.group(1);
			double valor = Double.parseDouble(numero);
			String valorFormateado = String.format("%.2f", valor);
			String textoFinal = "S/ " + valorFormateado;
			return textoFinal;
		} else {
			return texto;
		}
	}



	public static void tabAndClickCheckBox(WebDriver driver, WebElement webElement) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		//webElement.click();
	}
	public void pressSpaceKeyOnCheckbox(WebDriver driver, WebElement webElement){
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).sendKeys(" ").build().perform();
	}
	public int randomNumber(String tipo){
		int numero=0;
		switch (tipo) {
			case "correo":
				numero = random.nextInt(90000)+10000;
				break;
			case "dni":
				numero = random.nextInt(9000000)+1000000;
				break;
			case "movil":
				numero = random.nextInt(90000000)+10000000;
				break;
			default:
				System.out.println("Opción no reconocida");
		}
		return numero;
	}
	public String randomPhone(String movil){
		String nuevoMovil="";
		int index = movil.indexOf('9');
		if (index!=-1){
			String parteAntesDel9 = movil.substring(0, index + 1);
			nuevoMovil = parteAntesDel9 +randomNumber("movil");
		}else {
			System.out.println("No se encontro ningún elemento");
		}
		return nuevoMovil;
	}

	public String randomatoINgresoTexto(String valor){
		String nuevaCadena="";
		int indiceN = valor.indexOf('V');
		if (indiceN != -1) {
			String parteAntesDelV = valor.substring(0, indiceN + 1);
			nuevaCadena = parteAntesDelV + generateLetters(4);
		} else {
			System.out.println("La letra 'V' no se encontró en la cadena.");
		}
		return nuevaCadena;
	}
	public static String generateLetters(int longitud) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < longitud; i++) {
			int numeroAleatorio = random.nextInt(26);
			char letraAleatoria = (char) (numeroAleatorio + 97);
			sb.append(letraAleatoria);
		}
		return sb.toString();
	}


	public String randomEmail(String correo){
		String[] partes = correo.split("@");
		String dominio = partes[1];
		String parteLocalConNumero = generateLetters(4) +randomNumber("correo");
		return parteLocalConNumero + "@" + dominio;
	}
	public String randomDni(String dni){
		String nuevoDni="";
		int index = dni.indexOf('3');
		if (index!=-1){
			String parteAntesDel7 = dni.substring(0, index + 1);
			nuevoDni = parteAntesDel7 +randomNumber("dni");
		}else {
			System.out.println("No se encontro ningún elemento");
		}
		return nuevoDni;
	}


	public String randomNameLastAliaPass(String valor){
		String nuevaCadena="";
		int indiceN = valor.indexOf('V');
		if (indiceN != -1) {
			String parteAntesDelV = valor.substring(0, indiceN + 1);
			nuevaCadena = parteAntesDelV + generateLetters(4);
		} else {
			System.out.println("La letra 'V' no se encontró en la cadena.");
		}
		return nuevaCadena;
	}

	public void esperaImplicita(String webElement,int time){
		getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		element(webElement).click();
	}
}
