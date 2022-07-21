import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    LocalizationServiceImpl sut = new LocalizationServiceImpl();

    @Test
    public void testLocal(){
        Country countryTest = Country.USA;
        String expected = sut.locale(countryTest);
        Assertions.assertEquals(expected,"Welcome");
        countryTest = Country.RUSSIA;
        expected = sut.locale(countryTest);
        Assertions.assertEquals(expected,"Добро пожаловать");
    }
}
