package org.switch2023.adapter.rest.controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.switch2023.adapter.rest.to.DeviceTO;
import org.switch2023.domain.exception.NotFoundException;

@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
public interface DeviceRouter {

    @POST
    @Operation(summary = "Create a new device", description = "Creates a new device")
    @APIResponse(responseCode = "201",
                 description = "The device has been created.",
                 content = @Content(schema = @Schema(allOf = DeviceTO.class)))
    @APIResponse(responseCode = "400",
                 description = "The device couldn't be created.",
                 content = @Content(schema = @Schema(implementation = NotFoundException.class)))
    DeviceTO create(DeviceTO device);
}
