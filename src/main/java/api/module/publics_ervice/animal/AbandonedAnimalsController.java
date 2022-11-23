package api.module.publics_ervice.animal;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/animal/adopt")
public class AbandonedAnimalsController {
    @GetMapping
    public String adoptPage(){
        return "animal/adopt";
    }

    @ResponseBody
    @GetMapping("select")
    public String selectJson(){
        JSONObject jsonObj = null;

        return null;
    }
}
