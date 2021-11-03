package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Esta clase repesenta a la  entidad Bote
 * @author desaextremo
 */

@Entity
@Table(name = "boat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Identificador del Bote
     */
    private Integer id;
    /**
     * Nombre del Bote
     */
    private String name;
    /**
     * Marca del Bote
     */
    private String brand;
    /**
     * Año o modelo del bote
     */
    private Integer year;
    /**
     * Descripción del bote
     */
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("boats")
    /**
     * Categoria a la pertenece el Bote
     */
    private Category category;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties({"boat","client"})
    /**
     * Listado de mensajes asociados al Bote
     */
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties({"boat","messages"})
    /**
     * Listado de reservas asociadas al Bote
     */
    public List<Reservation> reservations;

}
