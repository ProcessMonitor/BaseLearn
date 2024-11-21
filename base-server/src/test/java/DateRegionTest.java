import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateRegionTest {

    @Test
    void dateRegion() {
        String dateString = "1942-01-01";
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
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

    @Test
    void timeFormatter() {
        // 输入的日期字符串（yyyyMMdd）
        String inputDate = "20241103";

        // 定义输入和输出的日期格式
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 将字符串解析为 LocalDate
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);

        // 格式化为所需的输出格式
        String formattedDate = date.format(outputFormatter);

        // 输出结果
        System.out.println("Formatted Date: " + formattedDate);

    }
}
