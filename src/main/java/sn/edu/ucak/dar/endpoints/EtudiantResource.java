package sn.edu.ucak.dar.endpoints;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sn.edu.ucak.dar.entities.Etudiant;

import java.util.List;

@Path("/api/etudiants")
public class EtudiantResource {

    @Inject
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Etudiant> getEtudiants() {
        return em.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Etudiant saveEtudiant(Etudiant etudiant) {
        em.persist(etudiant);
        return etudiant;
    }
}
