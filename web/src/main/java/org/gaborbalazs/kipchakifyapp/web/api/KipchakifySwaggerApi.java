package org.gaborbalazs.kipchakifyapp.web.api;

import org.springframework.http.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Kipchakify"})
@ApiModel(value = "Kipchakify", description = "Endpoints for translating text to kipchak")
public interface KipchakifySwaggerApi {

    @ApiOperation(value = "Welcome message", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiResponses( {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    String welcome();

    @ApiOperation(value = "Translate texts to kipchak", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiResponses( {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    String kipchakify(@ApiParam(value = "Text to kipchakify") String text);
}