import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;
import java.util.HashMap;
import java.util.Map;
import static ru.netology.entity.Country.RUSSIA;


public class MessageSenderImplTest {
    private static Map<String, String> headers = new HashMap<String, String>();

  @Test
    public void testSend(){
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER,"172.0.32.11");
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(RUSSIA))
            .thenReturn("Добро пожаловать");
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
            .thenReturn(new Location("Moscow", Country.RUSSIA, "null", 0));
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected = messageSender.send(headers);
        Assertions.assertEquals(expected,"Добро пожаловать");
    }
}
