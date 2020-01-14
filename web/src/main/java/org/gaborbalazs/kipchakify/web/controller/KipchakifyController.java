package org.gaborbalazs.kipchakify.web.controller;

import org.gaborbalazs.kipchakify.service.KipchakifyService;
import org.gaborbalazs.kipchakify.web.api.KipchakifyApi;
import org.gaborbalazs.kipchakify.web.api.KipchakifySwaggerApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
class KipchakifyController implements KipchakifyApi, KipchakifySwaggerApi {

    private KipchakifyService kipchakifyService;

    KipchakifyController(KipchakifyService kipchakifyService) {
        this.kipchakifyService = kipchakifyService;
    }

    @Override
    public String welcome() {
        return kipchakifyService.kipchakify("Üdvözöllek kicsi kipcsak!");
    }

    @Override
    public String kipchakify(String text) {
        return kipchakifyService.kipchakify(text);
    }
}
