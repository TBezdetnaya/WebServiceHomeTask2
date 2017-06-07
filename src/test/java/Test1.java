import convertSpeedService.ConvertSpeeds;
import convertSpeedService.ConvertSpeedsSoap;
import convertSpeedService.SpeedUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JaxWsHandlerResolver;

/**
 * Created by tanya on 04.06.2017.
 */
public class Test1 {
    private ConvertSpeedsSoap convertSpeedsSoap;
    private double expectedSpeed1 = 21.599999999999998;
    private double expectedSpeed2 = 54.863994899843036;
    @BeforeClass
    public void setUp() {

        ConvertSpeeds convertSpeeds = new ConvertSpeeds();
        convertSpeeds.setHandlerResolver(new JaxWsHandlerResolver());
        convertSpeedsSoap = convertSpeeds.getConvertSpeedsSoap();
    }
    @Test
    public void test(){

        double actualResult = convertSpeedsSoap.convertSpeed(6, SpeedUnit.CENTIMETERS_PERSECOND, SpeedUnit.KILOMETERS_PERHOUR);
        Assert.assertEquals(actualResult, expectedSpeed1);

    }
    @Test
    public void test2(){

        double actualResult = convertSpeedsSoap.convertSpeed(3000, SpeedUnit.FEET_PERMINUTE, SpeedUnit.KILOMETERS_PERHOUR);
        Assert.assertEquals(actualResult, expectedSpeed2);

    }
    @Test
    public void test3(){
        try{
            convertSpeedsSoap.convertSpeed(6, SpeedUnit.FEET_PERMINUTE, 0.56);
        } catch (ClassCastException exception){
            Assert.assertTrue(exception.getMessage().contains("java.lang.Double cannot be cast to convertSpeedService.SpeedUnit"));
        }




    }
}
