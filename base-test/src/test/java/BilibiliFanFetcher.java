import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
public class BilibiliFanFetcher {


   private static final String API_URL_UID = "https://api.bilibili.com/x/space/acc/info";
   private static final String API_URL_FANS = "https://api.bilibili.com/x/relation/stat";

   @Test
   @GetMapping("/fans")
   public void getFansCount() {
       String username = "Foara";
       log.info("Fetching fans count for username: {}", username);

       // 获取 UID 暂时接口无法调用 需要鉴权
//       String uid = fetchUid(username);
       // 手动填写uid
       String uid = "25399494";
       // 获取粉丝数量
       int fansCount = fetchFansCount(uid);

       System.out.println("My Wife's Fans count: " + fansCount);
   }

   private String fetchUid(String username) {
       try {
           String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8.toString());
           URL url = new URL(API_URL_UID + "?mid=0&name=" + encodedUsername);
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           connection.setRequestMethod("GET");

           BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           String inputLine;
           StringBuilder content = new StringBuilder();

           while ((inputLine = in.readLine()) != null) {
               content.append(inputLine);
           }
           in.close();

           JSONObject jsonObject = new JSONObject(content.toString());
           JSONObject data = jsonObject.getJSONObject("data");
           return data.getString("mid");
       } catch (IOException e) {
           log.error("Error fetching UID for username: {}", username, e);
           throw new RuntimeException("Error fetching UID", e);
       } catch (JSONException e) {
           throw new RuntimeException(e);
       }
   }

   private int fetchFansCount(String uid) {
       try {
           URL url = new URL(API_URL_FANS + "?vmid=" + uid);
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           connection.setRequestMethod("GET");

           BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           String inputLine;
           StringBuilder content = new StringBuilder();

           while ((inputLine = in.readLine()) != null) {
               content.append(inputLine);
           }
           in.close();

           JSONObject jsonObject = new JSONObject(content.toString());
           JSONObject data = jsonObject.getJSONObject("data");
           return data.getInt("follower");
       } catch (IOException e) {
           log.error("Error fetching fans count for UID: {}", uid, e);
           throw new RuntimeException("Error fetching fans count", e);
       } catch (JSONException e) {
           throw new RuntimeException(e);
       }
   }
}
