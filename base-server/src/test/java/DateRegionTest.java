import com.cheems.baseapi.shanghai.LongHuaResultDto;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateRegionTest {

    @Test
    void dateRegion() {
        String dateString = "1942-01-01";
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        // asia/shanghai
        fmt.setTimeZone(TimeZone.getTimeZone("CTT"));
        Date date = null;
        try {
            date = fmt.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(date);
    }
}
