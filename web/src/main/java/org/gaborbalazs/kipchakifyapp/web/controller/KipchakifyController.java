package org.gaborbalazs.kipchakifyapp.web.controller;

import org.gaborbalazs.kipchakifyapp.service.TranslatorService;
import org.gaborbalazs.kipchakifyapp.web.api.KipchakifyApi;
import org.gaborbalazs.kipchakifyapp.web.api.KipchakifySwaggerApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
class KipchakifyController implements KipchakifyApi, KipchakifySwaggerApi {

    private TranslatorService translatorService;

    KipchakifyController(TranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    @Override
    public String welcome() {
        return translatorService.translate("Üdvözöllek kicsi kipcsak!");
    }

    @Override
    public String kipchakify(String text) {
        return translatorService.translate(text);
    }
}
