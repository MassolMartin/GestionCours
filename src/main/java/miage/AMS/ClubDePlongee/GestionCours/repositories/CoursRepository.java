/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.AMS.ClubDePlongee.GestionCours.repositories;

import miage.AMS.ClubDePlongee.GestionCours.entities.Cours;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miage
 */
@Repository
public interface CoursRepository extends MongoRepository<Cours, String> {
    
}
