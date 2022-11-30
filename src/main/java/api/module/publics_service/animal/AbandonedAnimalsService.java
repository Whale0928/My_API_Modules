package api.module.publics_service.animal;

import api.module.publics_service.API_Connector;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class AbandonedAnimalsService {

    public String callApi() throws Exception {
        String key = "9Z%2FRt7EJguG7M5cGcaNE9kHzRxe1fS1%2FcgOWNQn3AyXg4a19A3almi%2FStT0WKlKYgikjqLNn5Wepnw9Hlup2DA%3D%3D";
        String path = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?numOfRows=30&pageNo=1&serviceKey=" + key + "&_type=json";

        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("ContentType", "application/json;charset=UTF-8");
        API_Connector connector = new API_Connector(con);

        //connector.request("GET", "ContentType", "application/json;charset=UTF-8", new JsonObject());
        return connector.response();
    }

}
