package com.grupo2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// creaciones de lombok
@Getter
@Setter
@ToString
@NoArgsConstructor // crea un constructor vacio
@AllArgsConstructor // crea un constructor con los parametros
@Builder //

@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    private Boolean activo;



    // En una categoria hay muchos productos
    // Y no es dueña de la relacion, en este caso es quieen tenga el atributo private Categoria categoria;
//    @OneToMany(mappedBy = "categoria", cascade = CascadeType.DETACH)
//    @ToString.Exclude
//    private List<Producto> productos = new ArrayList<>();
}
