import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RegionMapTest {

    @Test
    void regionMap() {

        LinkedHashMap REGION_RECORD_MAP = new LinkedHashMap<>();
        REGION_RECORD_MAP.put("11", "db-record-shanghai");
        REGION_RECORD_MAP.put("12", "db-record-wuhan");
        REGION_RECORD_MAP.put("13", "db-record-nanjing");
        REGION_RECORD_MAP.put("15", "db-record-changsha");
        REGION_RECORD_MAP.put("16", "db-record-bengbu");
        REGION_RECORD_MAP.put("1310", "db-record-xuzhou");
        REGION_RECORD_MAP.put("2510", "db-record-dongguan");
        REGION_RECORD_MAP.put("21", "db-record-changzhou");
        REGION_RECORD_MAP.put("20", "db-record-danyang");
        REGION_RECORD_MAP.put("19", "db-record-guangzhou");
        REGION_RECORD_MAP.put("32", "db-record-chongqing");
        REGION_RECORD_MAP.put("115010", "db-record-chenzhou");
        REGION_RECORD_MAP.put("1", "db-record-test");

        String regionJson = null;

        final String[] regions = StringUtils.defaultIfEmpty(regionJson,
                String.join(",", REGION_RECORD_MAP.values())).split(",");
        List<String> list = Arrays.stream(regions).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
