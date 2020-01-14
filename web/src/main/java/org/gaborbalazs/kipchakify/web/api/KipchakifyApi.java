package org.gaborbalazs.kipchakify.web.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/kipchakify")
public interface KipchakifyApi {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    String welcome();

    @RequestMapping(value = "/kipchakify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    String kipchakify(@RequestParam String text);
}
