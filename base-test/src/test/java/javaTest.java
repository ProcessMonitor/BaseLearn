import org.assertj.core.error.ClassModifierShouldBe;

import java.util.List;

public class javaTest {


    public int countConversationReturn(List<String> message) {
        int count = 0;
        String lastSender = "";
        for (String msg : message) {
            // 如果是sender:message 的模式
            String sender = msg.split(":")[0]; // 拿到sender
            if (lastSender != null && !sender.equals(lastSender)) {
                count++;
            }
            lastSender = sender;

        }
        return count;
    }
}
