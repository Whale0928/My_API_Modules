package api.module.publics_ervice.animal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class AbandonedAnimalsService {

    public String callApi() throws Exception {
        String key = "9Z%2FRt7EJguG7M5cGcaNE9kHzRxe1fS1%2FcgOWNQn3AyXg4a19A3almi%2FStT0WKlKYgikjqLNn5Wepnw9Hlup2DA%3D%3D";
        String path = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?numOfRows=30&pageNo=1&serviceKey=" + key + "&_type=json";

        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        JsonObject jsonObject = new JsonObject();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);


        BufferedReader br;
        if (responseCode == 200) { // 정상 호출
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {  // 에러 발생
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }

        br.close();
        return response.toString();
    }

}
