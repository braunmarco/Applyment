package de.braun.service;

import de.braun.domain.CurriculumVitae;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cvservice")
public class CurriculumVitaeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cv}")
    public CurriculumVitae getCV(@PathParam("cv") String title) {
        /*    CurriculumVitaeService cvService = new CurriculumVitaeService();
        CurriculumVitae cv = cvService.find(title);
        */
        return new CurriculumVitae();
    }
}
