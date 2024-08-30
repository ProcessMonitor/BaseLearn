public class AnfaDataT {

    public static void main(String[] args) {
        String str = "28周";
        String ageUnit = str.substring(str.length()-1);
        System.out.println(ageUnit);
        String ageNumber = str.replace(ageUnit, "");
        System.out.println(ageNumber);
    }


}
