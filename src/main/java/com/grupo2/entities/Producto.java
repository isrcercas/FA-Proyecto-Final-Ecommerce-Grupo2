package com.grupo2.entities;


import jakarta.persistence.*;
import lombok.*;

// creaciones de lombok
@Getter
@Setter
@ToString
@NoArgsConstructor // crea un constructor vacio
@AllArgsConstructor // crea un constructor con los parametros
@Builder //

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "categoria_id") // Nombre de la columna de la clave foránea
    private Categoria categoria;

}
