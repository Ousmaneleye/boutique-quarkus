package sn.edu.ucak.dar.endpoints;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sn.edu.ucak.dar.entities.Personne;

@Path("/api/personnes")
public class PersonneResource {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Personne savePersonne(Personne personne) {
        em.persist(personne);
        return personne;
    }
}
