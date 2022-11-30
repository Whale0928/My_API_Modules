package api.module.publics_service;

import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

public class API_Connector {
    private final HttpURLConnection http;

    public API_Connector(HttpURLConnection http) {
        this.http = http;
    }

    public void request(String method, String headerName, String headerValue, JsonObject jsonObject) throws Exception {
        http.setRequestMethod(method);
        http.setRequestProperty(headerName, headerValue);
        //POST 데이터 스트림 처리후 서버에 전송 (? )
        http.setDoOutput(true);

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(http.getOutputStream()));

        if (!jsonObject.isJsonNull())
            printWriter.write(jsonObject.toString());

        printWriter.flush();
    }

    public String response() throws Exception {
        BufferedReader reader;
        int status = http.getResponseCode();

        if (status == HttpURLConnection.HTTP_OK)
            reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
        else
            reader = new BufferedReader(new InputStreamReader(http.getErrorStream()));

        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        JSONObject jsonObject = new JSONObject(response.toString());
        return jsonObject.toString();
    }

}
