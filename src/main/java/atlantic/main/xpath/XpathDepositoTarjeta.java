package atlantic.main.xpath;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class XpathDepositoTarjeta {
    // singleton
    private static XpathDepositoTarjeta obj = null;
    private XpathDepositoTarjeta() {
    }
    public static XpathDepositoTarjeta getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathDepositoTarjeta();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final String Xpath_CheckTerminoCondiciones ="//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @id='niubiz_terms_check' and @data-indeterminate='false']";

    public final String Xpath_Siguiente ="//button[@id='depositButton' and contains(text(), 'Siguiente')]";

    @FindBy(xpath = "//div[@id='inputOtroMonto']")
    public static WebElement otroMonto;

    //public final String Xpath_iframe ="//iframe[@id='depositResponseIframe']";
    public final String Xpath_btnPagarSinTarjeta = "//*[@id='depositWithoutCardButton']";
    public final String Xpath_txtNumeroTarjeta = "//*[@id='cc-number']";
    public final String Xpath_txtMesAnnio = "//*[@id='cc-exp']";
    public final String Xpath_txtCVV = "//*[@id='cc-cvc']";
    public final String Xpath_btnDepositar = "//*[@id='depositButtonId']";


}
