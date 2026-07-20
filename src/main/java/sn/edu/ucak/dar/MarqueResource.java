package sn.edu.ucak.dar;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sn.edu.ucak.dar.entities.Marque;

import java.util.ArrayList;
import java.util.List;

@Path("/api/marques")
public class MarqueResource {

    @Inject
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marque> getAllMarques() {
        List<Marque> marques = new ArrayList<>();

        Marque lg = new Marque();
        lg.setNom("LG");
        marques.add(lg);

        Marque samsung = new Marque();
        samsung.setNom("Samsung");
        samsung.setDescription("Marque de test globale");
        marques.add(samsung);
        return marques ;
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Marque saveMarque(Marque marque) {
        em.persist(marque);
        return marque;
    }
}
