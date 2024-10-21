import org.apache.commons.lang3.StringUtils;

public class LongestSubstring {
    public static String longestSubstring(String s) {
        if(s == null || s.length() == 0){
            return StringUtils.EMPTY;
        }

        int maxCount = 1;
        int currentCount = 1;
        // 记录最大子串
        char maxChar = s.charAt(0);
        char currentChar = s.charAt(0);

        int maxLength = 0;
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxChar = currentChar;
                    maxLength = i - start;
                }
                currentCount = 1;
                currentChar = s.charAt(i);
                start = i;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxChar = currentChar;
        }
        return String.valueOf(maxChar).repeat(maxCount);
    }

    public static void main(String[] args) {
        String inputString = "aabbbbbccccccd";
        System.out.println(longestSubstring(inputString));
    }

}
