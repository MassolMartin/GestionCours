/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.AMS.ClubDePlongee.GestionCours.entities;

import java.util.Collection;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Représente un cours du club de plongée donné par un enseignant qui s'effectue dans une piscine sur toulouse
 * @author Miage
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "lescours")
public class Cours {
    
    @Id
    // Identifiant du cours
    private String id;
    
    @Field
    // Nom du cours
    private String nom;
    
    @Field
    // Niveau cible fixé pour le cours
    private Niveau niveauCible;
    
    @Field
    // Date du créneau du cours
    private Date creneau;
    
    @Field
    // Enseignant sur ce cours
    private String loginEnseignant;
    
    @Field
    // Lieu du cours
    private String lieu;
    
    @Field
    // Durée du cours
    private double duree;
    
    @Field
    // Liste des login des membres participants à ce cours
    Collection<String> participants;
}
