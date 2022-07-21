import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTestImpl {
    GeoServiceImpl sut = new GeoServiceImpl();

        @Test
        public void testByIp(){
            Location expected = sut.byIp("96.44.183.149");
            Assertions.assertNotNull(expected);
            Assertions.assertEquals(expected.getCountry(), Country.USA);
            System.out.println("Локация по ip проверена");
        }

        @Test
        public void testByCoordinatesExeception(){
        var expected = RuntimeException.class;
        Assertions.assertThrows(expected,()
                -> sut.byCoordinates(1.2,2.3));
        }
}
