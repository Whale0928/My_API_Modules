package api.module.publics_ervice.animal;

import com.google.gson.Gson;
import jdk.jfr.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AbandonedAnimalsController {

    private final AbandonedAnimalsService service;
    private final Gson gson;

    public AbandonedAnimalsController(AbandonedAnimalsService service, Gson gson) {
        this.service = service;
        this.gson = gson;
    }

    @GetMapping("/animal/adopt")
    public String adoptPage() {
        return "animal/adopt";
    }

    @ResponseBody
    @GetMapping(value="select",produces = "application/json")
    public String selectJson(HttpServletResponse response) throws Exception {
        return service.callApi();
    }
}
