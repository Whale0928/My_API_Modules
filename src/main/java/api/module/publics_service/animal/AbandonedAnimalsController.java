package api.module.publics_service.animal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AbandonedAnimalsController {

    private final AbandonedAnimalsService service;

    public AbandonedAnimalsController(AbandonedAnimalsService service) {
        this.service = service;
    }

    @GetMapping(value="/select")
    public String selectJson(Model model) throws Exception {
        return service.callApi();
    }
}
