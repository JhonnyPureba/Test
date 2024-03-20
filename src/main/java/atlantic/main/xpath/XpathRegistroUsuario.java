package atlantic.main.xpath;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;


public class XpathRegistroUsuario {
    // singleton
    private static XpathRegistroUsuario obj = null;
    private XpathRegistroUsuario() {
    }
    public static XpathRegistroUsuario getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathRegistroUsuario();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    public final String Xpath_btnRegistrar ="//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'styles_link__flZEQ', ' ' ))]";
    public final String Xpath_txtNombre ="//*[@id='firstname']";
    public final String Xpath_txtApePate ="//*[@id='paternalLastname']";
    public final String Xpath_txtApeMate ="//*[@id='maternalLastname']";
    public final String Xpath_txtEmail ="//*[@id='email']";
    public final String Xpath_txtDni ="//*[@id='national_id']";
    public final String Xpath_txtTelefono ="//*[@id='mobileNational']";
    public final String Xpath_txtCodPromocional ="//*[@id='codigoPromocional']";
    public final String Xpath_checkMayorEdad ="//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @name='usoDatos']";
    public final String Xpath_checkAutorizoTermiCondic ="//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @name='checkTerms']";
    public final String Xpath_btnSiguiente ="//*[@id='registerFormStep1']/div[2]/button";
    public String Xpath_txtPrimerCodigoSMS="//div[@class='otpInput_inputRow__htlgz']/input[1]";
    public String Xpath_txtSegundoCodigoSMS="//div[@class='otpInput_inputRow__htlgz']/input[2]";
    public String Xpath_txtTerceroCodigoSMS="//div[@class='otpInput_inputRow__htlgz']/input[3]";
    public String Xpath_txtCuartoCodigoSMS="//div[@class='otpInput_inputRow__htlgz']/input[4]";

    public String Xpath_txtPrimerCodigoSMSSegundoIntento="//div[@class='otpInput_inputRow__htlgz otpInput_inputRow_error__GplfW']//input[1]";
    public String Xpath_txtSegundoCodigoSMSSegundoIntento="//div[@class='otpInput_inputRow__htlgz otpInput_inputRow_error__GplfW']//input[2]";
    public String Xpath_txtTerceroCodigoSMSSegundoIntento="//div[@class='otpInput_inputRow__htlgz otpInput_inputRow_error__GplfW']//input[3]";
    public String Xpath_txtCuartoCodigoSMSSegundoIntento="//div[@class='otpInput_inputRow__htlgz otpInput_inputRow_error__GplfW']//input[4]";
    public final String Xpath_btnSiguientePasoTres ="//button[contains(text(), 'Siguiente')]";
    public final String Xpath_btnValidarCodigoSMS = "//button[@class='clmc-btn-primary' and text()='Validar']";
    public final String Xpath_txtUsuario ="//input[@id=':r9:' and @name='alias']";
    public final String Xpath_txtContrasenna ="//input[@id='registerPasswordInput' and @name='password']";
    public final String Xpath_rdbBono = "//input[@type='radio' and @value='REGISTERCASINO' and @name='REGISTERCASINO']";
    public final String xpath_finalizar = "//*[@id='btnSend']";
    public final String xpath_mesnajeCuentaCreada = "//p[@class='clmc-txtc clmc-text-black title' and contains(text(), '¡Genial, ya tienes una cuenta!')]";

    public final String xpath_IraDepositar="//button[contains(text(), 'Depositar Luego')]";
    public final String xpath_Casino= "//img[contains(@class, 'styles_casino-logo__3_VBk') and @alt='Logo']";
    public final String xpath_Deportivo="//img[contains(@class, 'styles_apuestas-logo__T6Q1Z') and @alt='Logo']";

}
