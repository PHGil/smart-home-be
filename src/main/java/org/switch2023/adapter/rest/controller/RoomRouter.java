package org.switch2023.adapter.rest.controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.switch2023.adapter.rest.to.RoomTO;
import org.switch2023.domain.exception.NotFoundException;

import java.util.List;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
public interface RoomRouter {

    @POST
    @Operation(summary = "Create a new room", description = "Creates a new room.")
    @APIResponse(responseCode = "201",
                 description = "The room has been created.",
                 content = @Content(schema = @Schema(allOf = RoomTO.class)))
    @APIResponse(responseCode = "400",
                 description = "The room couldn't be created.",
                 content = @Content(schema = @Schema(implementation = NotFoundException.class)))
    RoomTO createRoom(RoomTO room);

    @GET
    @Operation(summary = "Find all rooms", description = "Returns all rooms.")
    @APIResponse(responseCode = "200",
                 description = "List of all rooms.",
                 content = @Content(schema = @Schema(allOf = RoomTO.class)))
    List<RoomTO> findRooms();

    @GET
    @Operation(summary = "Find room by ID", description = "Returns a room by its identifier.")
    @APIResponse(responseCode = "200",
                 description = "Get room by ID",
                 content = @Content(schema = @Schema(allOf = RoomTO.class)))
    @APIResponse(responseCode = "404",
                 description = "The room could not be found",
                 content = @Content(schema = @Schema(implementation = NotFoundException.class)))
    @Path("/{id}")
    RoomTO findRoomById(@PathParam("id") Long id) throws NotFoundException;
}
