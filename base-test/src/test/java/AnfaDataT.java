import org.apache.commons.lang3.math.NumberUtils;

public class AnfaDataT {

    public static void main(String[] args) {
        String str = "10月";
        String ageUnit = str.substring(str.length() - NumberUtils.INTEGER_ONE.intValue(), str.length());
        System.out.println(ageUnit);
        String ageNumber = str.replace(ageUnit, "");
        System.out.println(ageNumber);
    }
}
