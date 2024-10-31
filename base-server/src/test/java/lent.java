public class lent {

    public static void main(String[] args) {
        String fileName = "113248^113248061912^99999901^Common^20241028112003^A5^LabResultReportA5_lw.pdf";

        System.out.println(fileName.length());
        System.out.println(fileName.split("\\^")[4]);
        System.out.println(fileName.split("\\^")[4].length());
    }
}
