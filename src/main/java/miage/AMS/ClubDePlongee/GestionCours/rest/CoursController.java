/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.AMS.ClubDePlongee.GestionCours.rest;


import java.util.ArrayList;
import java.util.Optional;
import miage.AMS.ClubDePlongee.GestionCours.entities.Cours;
import miage.AMS.ClubDePlongee.GestionCours.repositories.CoursRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Expose les services associé à un cours donné par un enseignant
 * @author Miage
 */
@RestController("/")
public class CoursController {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private CoursRepository coursRepo;
    
    /**
     * GET Tous les cours
     * @return la liste de tous les cours
     */
    @GetMapping("/liste")
    public Iterable<Cours> getListeCours() {
        return this.coursRepo.findAll();
    } 
    
    /**
     * POST Création d'un cours
     * @param c
     * @return un nouveau cours
     */
    @PostMapping("/nouveau")
    public Cours nouveauCours(@RequestBody Cours c) {
        logger.info("Nouveau cours enregistré");
        return this.coursRepo.save(c);
    }
    
    /**
     * POST Inscription d'un membre dans un cours
     * @param c
     * @param idm
     * @return un cours avec un membre inscrit en plus
     */
    @PostMapping("/inscription/{id}")
    public Cours inscriptionCours(@PathVariable("id") String c, @RequestBody String idm) {
        Optional<Cours> cours = this.coursRepo.findById(c);
        if(!cours.isPresent()) {
            logger.info("ERREUR : Ce cours est inexistant");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ce cours n'existe pas");
        } else {
            if(cours.get().getParticipants() == null) {
                cours.get().setParticipants(new ArrayList());
            }
            cours.get().getParticipants().add(idm);
            logger.info("Inscription à ce cours réussie");
            return this.coursRepo.save(cours.get());
        }
    }

    /**
     * GET un cours particulier
     * @param c
     * @return un cours
     */
    @GetMapping("/{id}")
    public Cours getCours(@PathVariable("id") Cours c) {
        Optional<Cours> cours = this.coursRepo.findById(c.getId());
        if(!cours.isPresent()) {
            logger.info("ERREUR : Cours inexistant");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ce cours n'existe pas");
        } else {
            return c;
        }
    } 
    
}
