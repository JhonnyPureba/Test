package atlantic.main.page;

import atlantic.main.util.PageObjectUtil;
import atlantic.main.util.UtilDef;
import atlantic.main.xpath.XpathIniciarSesion;
import atlantic.main.xpath.XpathIniciar_Sesion;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.casinoatlanticcity.com/")
public class PageIniciar_Sesion extends PageObject {

    @Managed(clearCookies = ClearCookiesPolicy.BeforeEachTest)


    private WebDriverWait wdw = null;
    private long wdwTimeOut = 300L;

    //protected PageObjecUtil pageObjectUtil = PageObjecUtil.getInstancia();
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

    UtilDef utilDef = new UtilDef();

    public void inicializar() {
        getDriver().get("https://www.casinoatlanticcity.com");
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
    }

    protected XpathIniciar_Sesion xpathIniciaro_Sesion = XpathIniciar_Sesion.getInstancia();

    public void seleccionarCookies(){
        pageObjectUtil.seleniumClick(getDriver(),xpathIniciaro_Sesion.Xpath_btnCookies,0);
    }

    public void seleccionarInicioSesion(){
        pageObjectUtil.seleniumClick(getDriver(), xpathIniciaro_Sesion.Xpath_btnCookies, 0);
        utilDef.esperarElemento(3,element(xpathIniciaro_Sesion.Xpath_btnIniciarSesion));
        element(xpathIniciaro_Sesion.Xpath_btnIniciarSesion).click();
    }
    public void seleccionarCasinoOnline(){
        pageObjectUtil.seleniumClick(getDriver(), xpathIniciaro_Sesion.Xpath_btnIrACasino, 0);
    }
    public void seleccionarVertical(String dato) {
        utilDef.esperarSegundos(4);
        pageObjectUtil.seleniumClick(getDriver(), xpathIniciaro_Sesion.retornarXpathParametroVertical(dato), 0);
    }
    public void ingresarDatosInicioSesion(String usuario, String password){
        pageObjectUtil.seleniumEscribir(getDriver(), xpathIniciaro_Sesion.Xpath_txtUsuario, usuario);
        pageObjectUtil.seleniumEscribir(getDriver(), xpathIniciaro_Sesion.Xpath_txtPassword, password);
    }

    public void seleccionarIngresar(){
        pageObjectUtil.seleniumClick(getDriver(), xpathIniciaro_Sesion.Xpath_btnIngresar, 0);
    }
    public void seleccionarCuentaIngresada() {
        try {
            Thread.sleep(3000);
            utilDef.esperarElemento(3,element(xpathIniciaro_Sesion.Xpath_btnCuentaIngresada));
            element(xpathIniciaro_Sesion.Xpath_btnCuentaIngresada).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getUsuarioLogueado() {
        Serenity.takeScreenshot();
        String modelo = pageObjectUtil.seleniumGetText(getDriver(), xpathIniciaro_Sesion.Xpath_lblUsuarioLogueado, 0);
        return modelo;
    }

}
