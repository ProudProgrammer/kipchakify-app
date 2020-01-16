package org.gaborbalazs.kipchakifyapp.service;

import org.gaborbalazs.kipchakify.KipchakifyService;
import org.springframework.stereotype.Service;

@Service
public class TranslatorService {

    private KipchakifyService kipchakifyService;

    TranslatorService(KipchakifyService kipchakifyService) {
        this.kipchakifyService = kipchakifyService;
    }

    public String translate(String text) {
        return kipchakifyService.kipchakify(text);
    }
}
