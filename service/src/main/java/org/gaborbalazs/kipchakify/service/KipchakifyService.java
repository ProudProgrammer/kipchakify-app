package org.gaborbalazs.kipchakify.service;

import org.gaborbalazs.kipchakify.Kipchakify;
import org.springframework.stereotype.Service;

@Service
public class KipchakifyService {

    private Kipchakify kipchakify;

    KipchakifyService(Kipchakify kipchakify) {
        this.kipchakify = kipchakify;
    }

    public String kipchakify(String text) {
        return kipchakify.kipchakify(text);
    }
}
